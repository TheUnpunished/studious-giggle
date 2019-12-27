package ru.kpfu.icmit.Yakovlev.pharmancy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.icmit.Yakovlev.pharmancy.forms.SqlForm;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QueryController {

    @Autowired
    DataSource dataSource;

    private List<String> runSelect(String sql){
        List<String> result = new ArrayList<>();
        try{
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            List<Integer> lengths = new ArrayList<>();
            for(int i=1; i<resultSetMetaData.getColumnCount()+1; i++){
                Integer length = resultSetMetaData.getColumnName(i).length();
                resultSet.beforeFirst();
                while (resultSet.next()){
                    if(resultSet.getString(i).length()>length)
                        length=resultSet.getString(i).length();
                }
                lengths.add(length+3);
            }
            String line = "";
            for(int i=1; i<resultSetMetaData.getColumnCount()+1; i++){
                String columnName = " " + resultSetMetaData.getColumnName(i);
                while(columnName.length()<lengths.get(i-1)){
                    columnName+=" ";
                }
                if(i!=resultSetMetaData.getColumnCount())
                    columnName+=" |";
                line+=columnName;
            }
            result.add(line);
            line="";
            int j=0;
            for(Integer len: lengths){
                for(int i=0;i<len+1;i++){
                    line += "-";
                }
                if(j++ != lengths.size()-1){
                    line +="+";
                }

            }
            result.add(line);
            resultSet.beforeFirst();
            int size=0;
            while (resultSet.next()){
                size++;
                line = "";
                for(int i=1; i<resultSetMetaData.getColumnCount()+1; i++){
                    String string = " "+resultSet.getString(i);
                    while(string.length()<lengths.get(i-1)){
                        string+=" ";
                    }
                    line +=string;
                    if(i!=resultSetMetaData.getColumnCount()){
                        line+=" |";
                    }
                }
                result.add(line);
            }
            line = "("+size+" row";
            if(size==1){
                line += ")";
            }
            else{
                line += "s)";
            }
            result.add(line);
        }
        catch (SQLException e){
            result = new ArrayList<>();
            result.add(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return result;
    }

    private String runOther(String sql){
        try{
            Statement statement = dataSource.getConnection().createStatement();
            statement.execute(sql);
            return "Запрос выполнен успешно.";
        }
        catch (SQLException e){
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    private String runQuery(@Valid SqlForm sqlForm, ModelMap modelMap){
        String sql = sqlForm.getSql();
        String type = sql.split(" ")[0].toLowerCase();
        List<String> resultList = new ArrayList<>();
        switch (type){
            case "select":
            case "select*":
            case "select(":{
                resultList.add("Запрос select выполнен успешно:");
                resultList.addAll(runSelect(sql));
                break;
            }
            default:{
                resultList.add(runOther(sql));
            }
        }
        modelMap.addAttribute("resultList", resultList);
        return "query";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    private String query(){
        return "query";
    }
}

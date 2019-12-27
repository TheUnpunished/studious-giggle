package ru.kpfu.icmit.Yakovlev.pharmancy.service;

import org.springframework.stereotype.Service;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Worker;
import ru.kpfu.icmit.Yakovlev.pharmancy.repository.WorkerRepository;

@Service
public class WorkerService extends CrudServiceImpl<Worker, WorkerRepository> {
    public WorkerService(WorkerRepository genericRepository) {
        super(genericRepository);
    }
}

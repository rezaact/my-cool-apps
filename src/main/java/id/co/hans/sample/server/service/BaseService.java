package id.co.hans.sample.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    @Autowired
    private ReportService reportService;

    public ReportService getReportService(){
        return reportService;
    }

}

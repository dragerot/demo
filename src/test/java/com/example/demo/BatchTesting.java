package com.example.demo;

import com.example.demo.config.BatchConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BatchConfiguration.class})
public class BatchTesting {

    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void enTest() throws Exception{
        BatchStatus jobExecution = jobLauncherTestUtils.launchJob().getStatus();
        Assert.assertTrue(jobExecution==BatchStatus.COMPLETED);
    }
}

package ru.orbot90.mybatistest;

import org.openjdk.jmh.annotations.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.orbot90.mybatistest.service.FooService;

import java.util.concurrent.TimeUnit;

/**
 * Created by orbot on 19.06.16.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class JMHTest {
    private volatile AnnotationConfigApplicationContext context;
    private volatile FooService fooService;

    @Setup
    public void start() {
        context = new AnnotationConfigApplicationContext();
        context.scan("ru.orbot90");
        context.refresh();

        fooService = context.getBean(FooService.class);
    }

    @Benchmark
    public void testMybatis() {
        fooService.doSomeBusinessStuff("1234");
    }

    @Benchmark
    public void testSpringData() {
        fooService.doSomeJpaBusinessStuff("1234");
    }

    @Benchmark
    public void testJdbcTemplate() {
        fooService.doSomeJDBCBusinessStuff("1234");
    }

    @Benchmark
    public void testSpringMediatorMybatis() {
        fooService.selectWithMediator("1234");
    }

//    @Benchmark
//    public void testUpdateMybatis() {
//        fooService.someMybatisUpdate();
//    }
//
//    @Benchmark
//    public void testUpdateJpa() {
//        fooService.someJpaUpdate();
//    }
//
//    @Benchmark
//    public void testUpdateJdbc() {
//        fooService.someJdbcUpdate();
//    }
}

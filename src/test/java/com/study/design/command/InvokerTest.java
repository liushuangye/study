package com.study.design.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvokerTest {
    @Test
    public void test(){
        //命令的接收者/执行者
        Receiver receiver = new Receiver();
        //命令们
        ICommand open = new OpenCommand(receiver);
        ICommand add_1 = new AddLightCommand(receiver);
        ICommand add_2 = new AddLightCommand(receiver);
        //调用者
        Invoker invoker = new Invoker();
        //将命令们添加到命令列表，列表接收的是ICommand，不关心是什么命令，也不关心执行者
        invoker.addCommand(open);
        invoker.addCommand(add_1);
        invoker.addCommand(add_2);
        //执行列表中的命令
        invoker.action();
    }
}
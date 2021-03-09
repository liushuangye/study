package com.study.design.command;

public class OpenCommand implements ICommand{
    private Receiver receiver;//命令的接收/执行者
    public OpenCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void excute() {
        receiver.open();//接收者执行命令
    }
}

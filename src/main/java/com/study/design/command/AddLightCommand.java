package com.study.design.command;

public class AddLightCommand implements ICommand{
    private Receiver receiver;//命令的接收/执行者
    public AddLightCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void excute() {
        receiver.addLight();//接收者执行命令
    }
}

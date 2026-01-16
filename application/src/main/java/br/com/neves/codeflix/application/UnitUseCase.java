package br.com.neves.codeflix.application;

public abstract class UnitUseCase<IN> {
    public abstract void execute(IN aInput);
}

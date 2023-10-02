package com.BaberShop.BaberShop.Service;

import com.BaberShop.BaberShop.Enums.StatusLancamento;
import com.BaberShop.BaberShop.model.Lancamento;

import java.util.List;

public interface LancamentoService {

    Lancamento salvar(Lancamento lancamento);
    Lancamento atualizar(Lancamento lancamento);
    void deletar(Lancamento lancamento);
    List<Lancamento> buscar(Lancamento lancamentoFiltro);
    void atualizarStatus(Lancamento lancamento, StatusLancamento status);
    void validar(Lancamento lancamento);
}

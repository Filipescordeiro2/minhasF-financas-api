package com.BaberShop.BaberShop.Service;

import com.BaberShop.BaberShop.Enums.StatusLancamento;
import com.BaberShop.BaberShop.model.Lancamento;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface LancamentoService {

    Lancamento salvar(Lancamento lancamento);
    Lancamento atualizar(Lancamento lancamento);
    void deletar(Lancamento lancamento);
    List<Lancamento> buscar(Lancamento lancamentoFiltro);
    void atualizarStatus(Lancamento lancamento, StatusLancamento status);
    void validar(Lancamento lancamento);
    Optional<Lancamento>obterPorId(Long id);
    BigDecimal obterSaldoPorUsuario(Long id);
}

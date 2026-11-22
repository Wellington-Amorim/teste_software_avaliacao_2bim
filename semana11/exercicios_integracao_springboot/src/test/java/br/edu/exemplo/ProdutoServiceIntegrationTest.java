package br.edu.exemplo;

import br.edu.exemplo.model.Produto;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProdutoServiceIntegrationTest {

 @Autowired
 ProdutoService service;

 @Autowired
 ProdutoRepository repository;

 @Test
 void deveCadastrarERecuperarProduto() {
  Produto salvo = service.cadastrar("Teclado", 150.0);

  assertNotNull(salvo.getId());

  Produto recuperado = repository.findById(salvo.getId()).orElseThrow();
  assertEquals("Teclado", recuperado.getNome());
  assertEquals(150.0, recuperado.getPreco());
 }

 @Test
 void naoDevePersistirProdutoComNomeEmBranco() {
  long contagemInicial = repository.count();

  assertThrows(IllegalArgumentException.class, () -> {
   service.cadastrar("   ", 80.0);
  });

  assertEquals(contagemInicial, repository.count());
 }

 @Test
 void deveAtualizarPrecoPersistido() {
  Produto salvo = service.cadastrar("Mouse", 80.0);

  service.atualizarPreco(salvo.getId(), 95.0);

  Produto atualizado = repository.findById(salvo.getId()).orElseThrow();
  assertEquals(95.0, atualizado.getPreco());
 }
}
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Produto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest {
	Produto produto, copia;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		produto = new Produto(id, "1", "Macarr�o", "Prato Principal", "25.00");
		copia = new Produto(id, "1", "Macarr�o", "Prato Principal", "25.00");
		System.out.println(produto);
		System.out.println(copia);
		System.out.println(id);
	}

	@Test
	public void testCarregar() {
		System.out.println("carregar");
		Produto fixture = new Produto(1, "2", "Ab�bora com carne de soja no tacho", "Prato", "45.50");
		Produto novo = new Produto(-1, null, null, null, null);
		novo.carregar(id);
		assertEquals("testa inclusao", novo, fixture);
	}
					
	@Test
	public void testCriar() {
		System.out.println("criar");
		produto.criar();
		id = produto.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", produto, copia);
	}
	
	@Test
	public void testAtualizar() {
		System.out.println("atualizar");
		produto.setTipo("Sobremesa");
		copia.setTipo("Sobremesa");
		produto.atualizar();
		produto.carregar(id);
		assertEquals("testa atualizacao", produto, copia);
	}

	@Test
	public void testExcluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setCodProduto(null);
		copia.setDescricao(null);
		copia.setTipo(null);
		copia.setPreco(null);
		produto.excluir(id);
		produto.carregar(id);
		assertEquals("testa exclusao", produto, copia);
	}
	
}

package sistemadetestes;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sistemadetestes.pageObject.ProdutoPO;
import sistemadetestes.test.BaseTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
//import static org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {

    private static ProdutoPO produtoPage;
    private final String IDCODIGO001 = "1234";
    private final String IDCODIGO002 = "6543";

    public static void prepararTestes() {
        produtoPage = new ProdutoPO(driver);
    }

    @Test
    public void T001_camposPreenchidosCadastro() {
        produtoPage.cadastrarProdutosPreenchidos("1234", "pao", "1.00");

        assertThat(IDCODIGO01, is("1234"));
    }

    @Test
    public void T002_ExcluirProdutoCadastrado() {
        produtoPage.buttonExcluir.click();
        boolean resultadoDaConferencia = produtoPage.confere(produtoPage.valorCodigo);
        assertFalse(resultadoDaConferencia);
    }

    @Test
    public void T003_cadastrarProdutosSemCodigo() {
        produtoPage.cadastrarProdutoSemCodigo("6543", "bisnaguinha", "5.00");
        String mensagem = produtoPage.erroMensagem();
        assertEquals(mensagem, "sao obrigatorio os codigos do produto para cadastro");

    }
}


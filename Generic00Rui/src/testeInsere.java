import java.sql.SQLException;
import java.util.List;

import mz.co.lunguissa.objectos.Mesa;
import mz.com.lunguissa.baseDados.ContatoDAO;


public class testeInsere {

	public static void main(String[] args) throws SQLException {
		
		
		
		
		Mesa mesa= new Mesa();
		mesa.setPartidoFrelimo("0");
		mesa.setPartidoMdm("0");
		mesa.setPartidoRenamo("0");
		mesa.setPartido("0");
		
		
		ContatoDAO dao= new ContatoDAO();
		dao.altera(mesa);
		List<Mesa> Mesas=dao.getLista();
		System.out.println(Mesas.get(0).getPartidoFrelimo());

	}

}

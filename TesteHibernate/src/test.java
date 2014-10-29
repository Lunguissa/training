import java.util.ArrayList;

import com.teste.model.Actividade;
import com.teste.model.User;
import com.teste.view.Menu;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu menu= new Menu();
		
		User u= new User("Rui", "Fernandes", true);
		User u1= new User("Diogo", "Amaral", true);
		User u2= new User("Hasler", "Choo", true);
		User u3= new User("Marcel", "Saraiva", true);
		User u4= new User("Victor", "hugo", true);
		User u5=new User("Tassio", "Rosario", true);
		ArrayList<User> hospital= new ArrayList<User>();
		ArrayList<User> website= new ArrayList<User>();
		ArrayList<User> user= new ArrayList<User>();
		user.add(u);
		user.add(u1);
		user.add(u2);
		user.add(u3);
		user.add(u4);
		user.add(u5);
		hospital.add(u1);
		hospital.add(u5);
		website.add(u2);
		Actividade a1= new Actividade(1, "Hospital", "O Lorem Ipsum é um texto modelo da indústria tipográfica e de impressão. O Lorem Ipsum tem vindo a ser o texto padrão usado por estas indústrias desde o ano de 1500, quando uma misturou os caracteres de um texto para criar um espécime de livro. Este texto não só sobreviveu 5 séculos, mas também o salto para a tipografia electrónica, mantendo-se essencialmente inalterada. Foi popularizada nos anos 60 com a disponibilização das folhas de Letraset, que continham passagens com Lorem Ipsum, e mais recentemente com os programas de publicação como o Aldus PageMaker que incluem versões do Lorem Ipsum.", hospital);
		Actividade a2= new Actividade(2, "website", "O Lorem Ipsum é um texto modelo da indústria tipográfica e de impressão. O Lorem Ipsum tem vindo a ser o texto padrão usado por estas indústrias desde o ano de 1500, quando uma misturou os caracteres de um texto para criar um espécime de livro. Este texto não só sobreviveu 5 séculos, mas também o salto para a tipografia electrónica, mantendo-se essencialmente inalterada. Foi popularizada nos anos 60 com a disponibilização das folhas de Letraset, que continham passagens com Lorem Ipsum, e mais recentemente com os programas de publicação como o Aldus PageMaker que incluem versões do Lorem Ipsum.", website);
		
		
		ArrayList<Actividade> activities= new ArrayList<Actividade>();
		activities.add(a1);
		activities.add(a2);
		
		menu.login(activities,user);
	}

}

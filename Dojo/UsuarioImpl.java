
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UsuarioImpl implements Usuario {

	private static final long serialVersionUID = 1L;
	private String nome;
	private List<Postagem> posts;
	private List<Usuario> seguidos;
	private List<Directs> directs;

	public UsuarioImpl(String nome) {
		this.nome = nome;
		this.posts = new LinkedList<Postagem>();
		this.seguidos = new LinkedList<Usuario>();
		this.directs = new LinkedList<Directs>();
	}
	
	@Override
	public String getNome() throws RemoteException {
		return nome;
	}

	@Override
	public List<Postagem> getPosts() throws RemoteException {
		return posts;
	}
	
	@Override
	public List<Usuario> getSeguidos() throws RemoteException {
		return seguidos;
	}
	
	@Override
	public void seguirOutroUsuario(Usuario outroUsuario) throws RemoteException {
		seguidos.add(outroUsuario);
	}
	
	@Override
	public Postagem criaPost(String mensagem) throws RemoteException {
		Postagem post = new Postagem(nome, mensagem);
		posts.add(post);
		return(post);
	}

	@Override
	public List<Postagem> filtraPosts(LocalDateTime inicio, LocalDateTime fim) throws RemoteException {
		List<Postagem> filtrados = new LinkedList<Postagem>();
		for (Postagem post : posts) {
			LocalDateTime timestamp = post.getTimestamp();
			if ((timestamp.isAfter(inicio) | timestamp.isEqual(inicio)) &
					(timestamp.isBefore(fim) | timestamp.isEqual(fim))) {
				filtrados.add(post);
			}
		}
		return filtrados;
	}
	
	@Override
	public Set<Postagem> geraLinhaDoTempo(LocalDateTime inicio, LocalDateTime fim) throws RemoteException {
		Set<Postagem> posts = new TreeSet<Postagem>();
		for (Usuario seguido : seguidos) {
			posts.addAll(seguido.filtraPosts(inicio, fim));
		}
		return posts;
	}

	@Override
	public void enviarDM(String mensagem, Usuario userReceiver , Usuario userSend) throws RemoteException {
		// TODO Auto-generated method stub
		Directs dir = new Directs(mensagem,userReceiver,userSend);
		this.directs.add(dir);
		
		
	}
	
	@Override
	public List<Directs> getDirects() throws RemoteException {
		// TODO Auto-generated method stub
		return this.directs;
	}
}

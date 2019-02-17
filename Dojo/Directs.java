import java.io.Serializable;

public class Directs implements Serializable {

	private static final long serialVersionUID = 1L;

	private String direct;
	
	private Usuario userReceiver;
	
	private Usuario userSend;

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	public Usuario getUserReceiver() {
		return userReceiver;
	}

	public void setUserReceiver(Usuario userReceiver) {
		this.userReceiver = userReceiver;
	}

	public Usuario getUserSend() {
		return userSend;
	}

	public void setUserSend(Usuario userSend) {
		this.userSend = userSend;
	}
	
	/*
	 * Default;
	 */
	public Directs(){
		
	}
	
	Directs(String direct , Usuario userReceiver , Usuario userSend){
		this.direct=direct;
		this.userReceiver=userReceiver;
		this.userSend=userSend;
	}
}

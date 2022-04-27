import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.glsid.entities.Compte;
import org.glsid.serviceRMI.BanqueRmiRemote;
/*clien RMI dans pring boot 
ajout pour le test avec la fusion,nous sommes le 27/04
*/
public class ClientRMI {

	public static void main(String[] args) 
	{

		try 
		{
			BanqueRmiRemote stub = (BanqueRmiRemote) Naming.lookup("rmi://localhost:1099/BK");
			Compte cpte = stub.getCompte("CC3");
			System.out.println(cpte.getSolde());
			System.out.println(cpte.getIdCompte());
			System.out.println(cpte.getDateCreation());
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		} 
	}

}

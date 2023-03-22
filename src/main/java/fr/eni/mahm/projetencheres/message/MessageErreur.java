package fr.eni.mahm.projetencheres.message;

import java.util.ResourceBundle;

public class MessageErreur {
	public abstract class LecteurMessage {
		private static ResourceBundle rb;
		
		static {
		
			try
			{
				rb = ResourceBundle.getBundle("fr.eni.mahm.projetencheres.message.messages_erreur");
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
}
}

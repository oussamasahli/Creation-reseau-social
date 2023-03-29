package services;
//import tools.CommentTools;
import java.util.List;
import java.util.ArrayList;
//import java.util.Arrays;

import org.bson.types.ObjectId;
import org.json.JSONArray;
//import org.json.JSONObject;

public class ListMessage {
	
	//La jai fait en sorte que tous les messageq soit des objets json dans un jsontableau

	public static JSONArray listMessage(String id,String query,String list_id) {
		
		
		if((id==null)||(query==null)||(list_id==null))
			//j'affiche tous les message --> getMessages()
			return ErrorJSON.serviceRefusedComment("Erreur argument",-1); // on appelle la methode service Refused de la classe ErrorJSON
		
		//Verification si les utisateur existent --> pour id et chacun desutilisateur de la liste
		//si au moins un n'existe pas retourne null
		
		
		if(id!=null && list_id != null) {
			
			List<String> Totalmessages=new ArrayList<String>();
			List<ObjectId> TotalIdmessages=new ArrayList<ObjectId>();
			List<String> TotalLogins= new ArrayList<String>();
			List<String> TotalDate= new ArrayList<String>();
			
			
			
			
					
			if(tools.UserTools.userExist(id)){
				List<String> mes_messages=new ArrayList<String>();
				mes_messages=tools.CommentTools.getMessage(id); //retourne les messages de l'utilisateur
				//filtrer les messages , garder ceux qui contienne query dans leur chaine
				List<String> mes_messages_filtres;
				List<ObjectId> Ensemble__Id_message_dun_utilisateur_filtre;
				
				mes_messages_filtres=tools.CommentTools.filtreMessages(mes_messages,query);
				Ensemble__Id_message_dun_utilisateur_filtre=tools.CommentTools.filtreIdMessages(id,query);
				
				Totalmessages.addAll(mes_messages_filtres);
				TotalIdmessages.addAll(Ensemble__Id_message_dun_utilisateur_filtre);
				
				for(int i=0;i<mes_messages_filtres.size(); i++) {
					TotalLogins.add(tools.UserTools.getLogins(id));
					TotalDate.add(tools.CommentTools.getDateMessage(Ensemble__Id_message_dun_utilisateur_filtre.get(i)));
				}
						
			}
			
			
			String[] my_list=list_id.split(",");
			List<String> Ensemble_de_tous_les_messages=new ArrayList<String>();
			List<ObjectId> Ensemble_de_tous_les_id_mesages=new ArrayList<ObjectId>();
			List<String> Ensemble_message_dun_utilisateur;
			List<String> Ensemble_message_dun_utilisateur_filtre;
			List<ObjectId> Ensemble__Id_message_dun_utilisateur_filtre;
			
			
			for(String id_other: my_list) {  // En supposant que dans la query String j'ai ecrit list_id=1569,1548,1697  -> je s�pare les diff�rent id avec des virgules
				
				if(id_other!=null) {
					Ensemble_message_dun_utilisateur=new ArrayList<String>();
					if(tools.UserTools.userExist(id_other)) {
						Ensemble_message_dun_utilisateur=tools.CommentTools.getMessage(id_other);
						Ensemble_message_dun_utilisateur_filtre=tools.CommentTools.filtreMessages(Ensemble_message_dun_utilisateur,query);
						Ensemble__Id_message_dun_utilisateur_filtre=tools.CommentTools.filtreIdMessages(id_other,query);
						Ensemble_de_tous_les_messages.addAll(Ensemble_message_dun_utilisateur_filtre); // jajoute tous les messages filtr�s de lensemble des utilisateur dans un Ensemble commun
						Ensemble_de_tous_les_id_mesages.addAll(Ensemble__Id_message_dun_utilisateur_filtre);
						
						for(int i=0;i<Ensemble_message_dun_utilisateur_filtre.size(); i++) {
							TotalLogins.add(tools.UserTools.getLogins(id_other));
							TotalDate.add(tools.CommentTools.getDateMessage(Ensemble_de_tous_les_id_mesages.get(i)));
						}
						
					}
				}
				
			}
			
			Totalmessages.addAll(Ensemble_de_tous_les_messages);
			TotalIdmessages.addAll(Ensemble_de_tous_les_id_mesages);
					

			return ErrorJSON.serviceAcceptedComment(Totalmessages,TotalIdmessages,TotalLogins,TotalDate);

			
		}
		
//---------------------------------------------------------------------------------------------------------------------------------
		
		if(id!=null) {
			List<String> TotalLogins= new ArrayList<String>();
			List<String> TotalDate= new ArrayList<String>();
			
			if(tools.UserTools.userExist(id)){
				List<String> mes_messages=new ArrayList<String>();
				mes_messages=tools.CommentTools.getMessage(id); //retourne les messages de l'utilisateur
				//filtrer les messages , garder ceux qui contienne query dans leur chaine
				List<String> mes_messages_filtres;
				List<ObjectId> Ensemble__Id_message_dun_utilisateur_filtre;
				
				mes_messages_filtres=tools.CommentTools.filtreMessages(mes_messages,query);
				Ensemble__Id_message_dun_utilisateur_filtre=tools.CommentTools.filtreIdMessages(id,query);
				//en Sortie jaffiche les commentaires qui ont �t� r�cupr�
				
				for(int i=0;i<mes_messages_filtres.size(); i++) {
					TotalLogins.add(tools.UserTools.getLogins(id));
					TotalDate.add(tools.CommentTools.getDateMessage(Ensemble__Id_message_dun_utilisateur_filtre.get(i)));
				}

				return ErrorJSON.serviceAcceptedComment(mes_messages_filtres,Ensemble__Id_message_dun_utilisateur_filtre,TotalLogins,TotalDate);
			}							
		}
		
//------------------------------------------------------------------------------------------------------------------------------------
		
		
		//sinon je parcours la liste des autres utilisateurs et japplique le meme traitement qu'au dessus	
		String[] my_list=list_id.split(",");
		List<String> Ensemble_de_tous_les_messages=new ArrayList<String>();
		List<ObjectId> Ensemble_de_tous_les_id_mesages=new ArrayList<ObjectId>();
		List<String> Ensemble_message_dun_utilisateur;
		List<String> Ensemble_message_dun_utilisateur_filtre;
		List<ObjectId> Ensemble__Id_message_dun_utilisateur_filtre;
		List<String> TotalLogins= new ArrayList<String>();
		List<String> TotalDate= new ArrayList<String>();
		
		
		for(String id_other: my_list) {  // En supposant que dans la query String j'ai ecrit list_id=1569,1548,1697  -> je s�pare les diff�rent id avec des virgules
			
			if(id_other!=null) {
				Ensemble_message_dun_utilisateur=new ArrayList<String>();
				if(tools.UserTools.userExist(id_other)) {
					Ensemble_message_dun_utilisateur=tools.CommentTools.getMessage(id_other);
					Ensemble_message_dun_utilisateur_filtre=tools.CommentTools.filtreMessages(Ensemble_message_dun_utilisateur,query);
					Ensemble__Id_message_dun_utilisateur_filtre=tools.CommentTools.filtreIdMessages(id_other,query);
					Ensemble_de_tous_les_messages.addAll(Ensemble_message_dun_utilisateur_filtre); // jajoute tous les messages filtr�s de lensemble des utilisateur dans un Ensemble commun
					Ensemble_de_tous_les_id_mesages.addAll(Ensemble__Id_message_dun_utilisateur_filtre);
					
					for(int i=0;i<Ensemble_message_dun_utilisateur_filtre.size(); i++) {
						TotalLogins.add(tools.UserTools.getLogins(id_other));
						TotalDate.add(tools.CommentTools.getDateMessage(Ensemble_de_tous_les_id_mesages.get(i)));
					}
			
				}
			}
			
		}
		
		return ErrorJSON.serviceAcceptedComment(Ensemble_de_tous_les_messages,Ensemble_de_tous_les_id_mesages,TotalLogins,TotalDate);
		
		
	}
}

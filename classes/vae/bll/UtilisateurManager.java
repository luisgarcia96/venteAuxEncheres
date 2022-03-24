/*    */ package WEB-INF.classes.vae.bll;
/*    */ 
/*    */ import vae.bo.Utilisateur;
/*    */ import vae.dal.DAOFactory;
/*    */ import vae.dal.UtilisateurDAO;
/*    */ import vae.exceptions.BusinessException;
/*    */ 
/*    */ public class UtilisateurManager
/*    */ {
/*    */   private static UtilisateurDAO utilisateurDAO;
/*    */   private static vae.bll.UtilisateurManager utilisateurManager;
/*    */   
/*    */   public UtilisateurManager() {
/* 14 */     utilisateurDAO = DAOFactory.getUtilisateurDAO();
/*    */   }
/*    */   
/*    */   public static vae.bll.UtilisateurManager getUtilisateurManager() {
/* 18 */     if (utilisateurManager == null) {
/* 19 */       utilisateurManager = new vae.bll.UtilisateurManager();
/*    */     }
/* 21 */     return utilisateurManager;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Utilisateur connexion(String login, String motDePasse) throws BusinessException {
/* 28 */     Utilisateur utilisateur = new Utilisateur();
/* 29 */     utilisateur = utilisateurDAO.connexion(login, motDePasse);
/* 30 */     return utilisateur;
/*    */   }
/*    */ 
/*    */   
/*    */   public Boolean createUtilisateur(Utilisateur utilisateur) throws BusinessException {
/* 35 */     Boolean NoPseudoEmail = Boolean.valueOf(false);
/*    */ 
/*    */     
/* 38 */     NoPseudoEmail = utilisateurDAO.checkNoPseudoEmail(utilisateur);
/* 39 */     if (NoPseudoEmail.booleanValue()) {
/*    */       
/*    */       try {
/* 42 */         utilisateurDAO.createUtilisateur(utilisateur);
/* 43 */       } catch (BusinessException e) {
/* 44 */         e.printStackTrace();
/*    */       } 
/*    */     }
/* 47 */     return NoPseudoEmail;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Utilisateur selectUtilisateurByPseudo(String pseudo) throws BusinessException {
/* 53 */     Utilisateur utilisateur = utilisateurDAO.selectByPseudo(pseudo);
/* 54 */     return utilisateur;
/*    */   }
/*    */   
/*    */   public int recupererIdUtilisateur(String login) throws BusinessException {
/* 58 */     int noUtilisateur = 0;
/*    */     
/*    */     try {
/* 61 */       noUtilisateur = utilisateurDAO.recupererIdUtilisateur(login);
/* 62 */       return noUtilisateur;
/* 63 */     } catch (BusinessException e) {
/* 64 */       e.printStackTrace();
/*    */       
/* 66 */       return noUtilisateur;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void deleteUtilisateur(String pseudo) throws BusinessException {
/* 72 */     utilisateurDAO.deleteUtilisateur(pseudo);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean updateUtilisateur(Utilisateur utilisateur, String pseudoOld) throws BusinessException {
/* 77 */     Boolean NoPseudoEmail = Boolean.valueOf(false);
/*    */ 
/*    */     
/* 80 */     NoPseudoEmail = utilisateurDAO.checkNoPseudoEmailInUpdate(utilisateur, pseudoOld);
/* 81 */     if (NoPseudoEmail.booleanValue())
/*    */       
/*    */       try {
/* 84 */         utilisateurDAO.updateUtilisateur(utilisateur, pseudoOld);
/* 85 */         return true;
/* 86 */       } catch (BusinessException e) {
/*    */         
/* 88 */         e.printStackTrace();
/*    */         
/* 90 */         return false;
/*    */       }  
/* 92 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\bll\UtilisateurManager.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */
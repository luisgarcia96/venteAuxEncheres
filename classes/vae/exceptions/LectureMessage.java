/*    */ package WEB-INF.classes.vae.exceptions;
/*    */ 
/*    */ import java.util.ResourceBundle;
/*    */ 
/*    */ 
/*    */ public abstract class LectureMessage
/*    */ {
/*    */   private static ResourceBundle rb;
/*    */   
/*    */   static {
/*    */     try {
/* 12 */       rb = ResourceBundle.getBundle("vae.exceptions.messages_erreur");
/* 13 */     } catch (Exception e) {
/* 14 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getMessageErreur(int code) {
/* 21 */     String message = "";
/*    */     try {
/* 23 */       if (rb != null) {
/* 24 */         message = rb.getString(String.valueOf(code));
/*    */       } else {
/* 26 */         message = "Problème à la lecture du fichier contenant les messages";
/*    */       } 
/* 28 */     } catch (Exception e) {
/* 29 */       e.printStackTrace();
/* 30 */       message = "Une erreur inconnue est survenue";
/*    */     } 
/* 32 */     return message;
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\exceptions\LectureMessage.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package WEB-INF.classes.vae.exceptions;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class BusinessException extends Exception {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private List<Integer> listeCodesErreur;
/*    */   
/*    */   public BusinessException() {
/* 11 */     this.listeCodesErreur = new ArrayList<>();
/*    */   }
/*    */   
/*    */   public BusinessException(String message) {
/* 15 */     super(message);
/*    */   }
/*    */   
/*    */   public void ajouterErreur(int code) {
/* 19 */     if (!this.listeCodesErreur.contains(Integer.valueOf(code))) {
/* 20 */       this.listeCodesErreur.add(Integer.valueOf(code));
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean hasError() {
/* 25 */     return (this.listeCodesErreur.size() > 0);
/*    */   }
/*    */   
/*    */   public List<Integer> getListeCodesErreur() {
/* 29 */     return this.listeCodesErreur;
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\exceptions\BusinessException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */
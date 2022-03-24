/*    */ package WEB-INF.classes.vae.bo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Categorie
/*    */ {
/*    */   private int noCategorie;
/*    */   private String libelle;
/*    */   
/*    */   public Categorie() {}
/*    */   
/*    */   public Categorie(int noCategorie, String libelle) {
/* 13 */     this.noCategorie = noCategorie;
/* 14 */     this.libelle = libelle;
/*    */   }
/*    */   
/*    */   public Categorie(int noCategorie) {
/* 18 */     this.noCategorie = noCategorie;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getNoCategorie() {
/* 23 */     return this.noCategorie;
/*    */   }
/*    */   
/*    */   public void setNoCategorie(int noCategorie) {
/* 27 */     this.noCategorie = noCategorie;
/*    */   }
/*    */   public String getLibelle() {
/* 30 */     return this.libelle;
/*    */   }
/*    */   public void setLibelle(String libelle) {
/* 33 */     this.libelle = libelle;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 40 */     return "Categorie [noCategorie=" + this.noCategorie + ", libelle=" + this.libelle + "]";
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\bo\Categorie.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */
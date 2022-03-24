/*     */ package WEB-INF.classes.vae.dal;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import vae.bo.Utilisateur;
/*     */ import vae.dal.ConnectionProvider;
/*     */ import vae.dal.UtilisateurDAO;
/*     */ import vae.exceptions.BusinessException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UtilisateurDAOJdbcImpl
/*     */   implements UtilisateurDAO
/*     */ {
/*     */   private static final String VERIF_CON = "select pseudo, nom, administrateur FROM utilisateurs WHERE (email=? or pseudo=?) and mot_de_passe=?";
/*     */   private static final String CREATE_USER = "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0);";
/*     */   private static final String VERIF_NO_PSEUDO_EMAIL = "SELECT email, pseudo FROM utilisateurs WHERE email = ? OR pseudo = ?;";
/*     */   private static final String SELECT_BY_PSEUDO = "SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville FROM utilisateurs WHERE pseudo = ?;";
/*     */   private static final String RETRIEVE_USER_ID = "SELECT no_utilisateur FROM utilisateurs WHERE (email=? or pseudo=?)";
/*     */   private static final String DELETE_USER = "DELETE FROM utilisateurs WHERE pseudo=?";
/*     */   private static final String UPDATE_USER = "UPDATE utilisateurs SET pseudo = ?, nom = ?,prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?,ville = ? WHERE pseudo = ?;";
/*     */   private static final String UPDATE_USER_AND_PASSWORD = "UPDATE utilisateurs SET pseudo = ?, nom = ?,prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?,ville = ?, mot_de_passe = ? WHERE pseudo = ?;";
/*     */   
/*     */   public Utilisateur connexion(String login, String motDePasse) throws BusinessException {
/*     */     
/*  36 */     try { Exception exception1 = null, exception2 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {  }
/*     */       finally
/*  67 */       { exception2 = null; if (exception1 == null) { exception1 = exception2; } else if (exception1 != exception2) { exception1.addSuppressed(exception2); }  }  } catch (SQLException e)
/*     */     
/*  69 */     { BusinessException businessException = new BusinessException();
/*  70 */       businessException.ajouterErreur(10002);
/*  71 */       throw businessException; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createUtilisateur(Utilisateur utilisateur) throws BusinessException {
/*     */     try {
/*  80 */       Connection cnx = ConnectionProvider.getConnection();
/*  81 */       PreparedStatement pstmt = null;
/*     */       
/*  83 */       pstmt = cnx.prepareStatement("INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0);");
/*  84 */       pstmt.setString(1, utilisateur.getLogin());
/*  85 */       pstmt.setString(2, utilisateur.getNom());
/*  86 */       pstmt.setString(3, utilisateur.getPrenom());
/*  87 */       pstmt.setString(4, utilisateur.getEmail());
/*  88 */       pstmt.setString(5, utilisateur.getTelephone());
/*  89 */       pstmt.setString(6, utilisateur.getRue());
/*  90 */       pstmt.setString(7, utilisateur.getCodePostal());
/*  91 */       pstmt.setString(8, utilisateur.getVille());
/*  92 */       pstmt.setString(9, utilisateur.getMotDePasse());
/*  93 */       pstmt.setInt(10, utilisateur.getCredit());
/*     */       
/*  95 */       pstmt.executeUpdate();
/*     */       
/*  97 */       pstmt.close();
/*  98 */       cnx.close();
/*     */     
/*     */     }
/* 101 */     catch (SQLException e) {
/* 102 */       e.printStackTrace();
/* 103 */       BusinessException businessException = new BusinessException();
/* 104 */       businessException.ajouterErreur(10001);
/* 105 */       throw businessException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean checkNoPseudoEmail(Utilisateur utilisateur) throws BusinessException {
/* 113 */     PreparedStatement pstmt = null;
/* 114 */     Boolean noPseudoEmail = Boolean.valueOf(false);
/*     */     
/*     */     try {
/* 117 */       Connection cnx = ConnectionProvider.getConnection();
/* 118 */       pstmt = cnx.prepareStatement("SELECT email, pseudo FROM utilisateurs WHERE email = ? OR pseudo = ?;");
/*     */       
/* 120 */       pstmt.setString(1, utilisateur.getEmail());
/* 121 */       pstmt.setString(2, utilisateur.getLogin());
/*     */       
/* 123 */       ResultSet rs = pstmt.executeQuery();
/*     */ 
/*     */       
/* 126 */       if (rs.next()) {
/* 127 */         noPseudoEmail = Boolean.valueOf(false);
/*     */       } else {
/* 129 */         noPseudoEmail = Boolean.valueOf(true);
/*     */       } 
/*     */       
/* 132 */       pstmt.close();
/* 133 */       cnx.close();
/* 134 */       rs.close();
/* 135 */     } catch (SQLException e) {
/* 136 */       e.printStackTrace();
/*     */     } 
/* 138 */     return noPseudoEmail;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean checkNoPseudoEmailInUpdate(Utilisateur utilisateur, String pseudoOld) throws BusinessException {
/* 145 */     PreparedStatement pstmt = null;
/* 146 */     Boolean noPseudoEmail = Boolean.valueOf(false);
/*     */     
/*     */     try {
/* 149 */       Connection cnx = ConnectionProvider.getConnection();
/* 150 */       pstmt = cnx.prepareStatement("SELECT email, pseudo FROM utilisateurs WHERE email = ? OR pseudo = ?;");
/*     */       
/* 152 */       pstmt.setString(1, utilisateur.getEmail());
/* 153 */       pstmt.setString(2, utilisateur.getLogin());
/*     */       
/* 155 */       ResultSet rs = pstmt.executeQuery();
/*     */ 
/*     */       
/* 158 */       if (rs.next()) {
/*     */         
/* 160 */         if (rs.getString("pseudo").contentEquals(pseudoOld)) {
/* 161 */           noPseudoEmail = Boolean.valueOf(true);
/*     */         } else {
/* 163 */           noPseudoEmail = Boolean.valueOf(false);
/*     */         } 
/*     */       } else {
/*     */         
/* 167 */         noPseudoEmail = Boolean.valueOf(true);
/*     */       } 
/*     */       
/* 170 */       if (rs.next()) {
/* 171 */         noPseudoEmail = Boolean.valueOf(false);
/*     */       }
/*     */       
/* 174 */       pstmt.close();
/* 175 */       cnx.close();
/* 176 */       rs.close();
/*     */     }
/* 178 */     catch (SQLException e) {
/* 179 */       e.printStackTrace();
/*     */     } 
/* 181 */     return noPseudoEmail;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
/* 188 */     PreparedStatement pstmt = null;
/* 189 */     Utilisateur utilisateur = null;
/*     */     
/*     */     try {
/* 192 */       Connection cnx = ConnectionProvider.getConnection();
/* 193 */       pstmt = cnx.prepareStatement("SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville FROM utilisateurs WHERE pseudo = ?;");
/*     */       
/* 195 */       pstmt.setString(1, pseudo);
/*     */       
/* 197 */       ResultSet rs = pstmt.executeQuery();
/*     */       
/* 199 */       rs.next();
/* 200 */       utilisateur = setUtilisateurVal(rs);
/*     */       
/* 202 */       pstmt.close();
/* 203 */       cnx.close();
/* 204 */       rs.close();
/*     */     }
/* 206 */     catch (SQLException e) {
/* 207 */       e.printStackTrace();
/*     */     } 
/* 209 */     return utilisateur;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int recupererIdUtilisateur(String login) throws BusinessException {
/*     */     
/* 216 */     try { Exception exception1 = null, exception2 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {  }
/*     */       finally
/* 237 */       { exception2 = null; if (exception1 == null) { exception1 = exception2; } else if (exception1 != exception2) { exception1.addSuppressed(exception2); }  }  } catch (SQLException e)
/* 238 */     { BusinessException businessException = new BusinessException();
/* 239 */       businessException.ajouterErreur(10002);
/* 240 */       throw businessException; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void deleteUtilisateur(String pseudo) throws BusinessException {
/*     */     try {
/* 247 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 259 */     catch (SQLException e) {
/*     */       
/* 261 */       BusinessException businessException = new BusinessException();
/* 262 */       businessException.ajouterErreur(10004);
/* 263 */       throw businessException;
/*     */     } 
/*     */   }
/*     */   
/*     */   private Utilisateur setUtilisateurVal(ResultSet rs) {
/* 268 */     Utilisateur utilisateur = new Utilisateur();
/*     */     try {
/* 270 */       utilisateur.setLogin(rs.getString("pseudo"));
/* 271 */       utilisateur.setNom(rs.getString("nom"));
/* 272 */       utilisateur.setPrenom(rs.getString("prenom"));
/* 273 */       utilisateur.setEmail(rs.getString("email"));
/* 274 */       utilisateur.setTelephone(rs.getString("telephone"));
/* 275 */       utilisateur.setRue(rs.getString("rue"));
/* 276 */       utilisateur.setCodePostal(rs.getString("code_postal"));
/* 277 */       utilisateur.setVille(rs.getString("ville"));
/* 278 */     } catch (SQLException e) {
/* 279 */       e.printStackTrace();
/*     */     } 
/* 281 */     return utilisateur;
/*     */   }
/*     */   
/*     */   public void updateUtilisateur(Utilisateur utilisateur, String pseudoOld) throws BusinessException {
/*     */     try {
/* 286 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 324 */     catch (SQLException e) {
/* 325 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\dal\UtilisateurDAOJdbcImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */
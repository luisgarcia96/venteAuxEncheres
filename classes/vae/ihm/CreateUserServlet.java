/*    */ package WEB-INF.classes.vae.ihm;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.annotation.WebServlet;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import vae.bll.UtilisateurManager;
/*    */ import vae.bo.Utilisateur;
/*    */ import vae.exceptions.BusinessException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @WebServlet({"/createUser"})
/*    */ public class CreateUserServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 33 */     HttpSession session = request.getSession();
/* 34 */     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/createUser.jsp");
/* 35 */     rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 42 */     request.setCharacterEncoding("UTF-8");
/*    */     
/* 44 */     String pseudo = request.getParameter("pseudo");
/* 45 */     String nom = request.getParameter("nom");
/* 46 */     String prenom = request.getParameter("prenom");
/* 47 */     String email = request.getParameter("email");
/* 48 */     String telephone = request.getParameter("telephone");
/* 49 */     String adresse = request.getParameter("rue");
/* 50 */     String postal = request.getParameter("postal");
/* 51 */     String ville = request.getParameter("ville");
/* 52 */     String password = request.getParameter("password");
/* 53 */     String password2 = request.getParameter("password2");
/*    */ 
/*    */     
/* 56 */     if (password.contentEquals(password2)) {
/* 57 */       MessageDigest md = null;
/*    */       try {
/* 59 */         md = MessageDigest.getInstance("SHA-256");
/* 60 */       } catch (NoSuchAlgorithmException e) {
/* 61 */         e.printStackTrace();
/*    */       } 
/*    */       
/* 64 */       md.update(password.getBytes());
/* 65 */       byte[] byteData = md.digest();
/*    */       
/* 67 */       StringBuffer sb = new StringBuffer();
/* 68 */       for (int i = 0; i < byteData.length; i++) {
/* 69 */         sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
/*    */       }
/*    */       
/* 72 */       Boolean admin = Boolean.valueOf(false);
/* 73 */       int credit = 0;
/*    */       
/* 75 */       Utilisateur utilisateur = new Utilisateur(email, pseudo, sb.toString(), nom, prenom, telephone, adresse, postal, ville, admin, credit);
/* 76 */       UtilisateurManager utilisateurManager = new UtilisateurManager();
/*    */       
/*    */       try {
/* 79 */         utilisateurManager.createUtilisateur(utilisateur);
/* 80 */         RequestDispatcher rd = request.getRequestDispatcher("accueil");
/*    */         
/* 82 */         rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */       }
/* 84 */       catch (BusinessException e) {
/* 85 */         e.printStackTrace();
/* 86 */         doGet(request, response);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\ihm\CreateUserServlet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */
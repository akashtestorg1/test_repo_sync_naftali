
















{
    public static void main(String[] args)   
    {
        try {
            String email = request.getParameter("email");
            String token = request.getParameter("password");

            String sql = "select * from users where (email ='" + email +"' and password ='" + token + "')";

            Connection connection = pool.getConnection();
            Statement statement = connection.createStatement();
            
            HttpSession session = request.getSession();
            String role = (String)session.getAttribute("role");
            if (role.equals(ADMIN)) {
                ResultSet result = statement.executeQuery(sql);
                statement.close();
                connection.close();
            }




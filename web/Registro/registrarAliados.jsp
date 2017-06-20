<%@page import="java.io.File"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="java.util.ArrayList"%>
<%

    String nombre = "";
    String url = "";
    String foto = "";

    String ruta = request.getServletContext().getRealPath("/Aliados");
    FileItemFactory file_factory = new DiskFileItemFactory();
    ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
    List items = servlet_up.parseRequest(request);
    for (int i = 0; i < items.size(); i++) {
        FileItem item = (FileItem) items.get(i);
        boolean tipo = item.isFormField();
        if (!tipo) {
            BufferedInputStream buffIn = new BufferedInputStream(item.getInputStream());//Ruta del archivo para enviar
            int by = buffIn.available();
            if (by != 0) {
                try {
                    File archivo_server = new File(ruta);
                    if (!archivo_server.exists()) {
                        archivo_server.mkdir();
                    }
                    foto = ruta + "/" + item.getName();
                    File archivo = new File(foto);
                    item.write(archivo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            if (item.getFieldName().equalsIgnoreCase("nombre")) {
                nombre = item.getString("UTF-8");
            }
            if (item.getFieldName().equalsIgnoreCase("url")) {
                url = item.getString("UTF-8");
            }
        }
    }
    if (asunto.isEmpty()) {

        //out.print("Debe agregar un asunto a la tarea");
    } else {

    }

%>
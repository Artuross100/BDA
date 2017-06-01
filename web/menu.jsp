<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#myCarousel">Diocésis de Cúcuta</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#about">Nosotros</a>
                </li>
                <li>
                    <a href="#aliados">Aliados</a>
                </li>
                <li>
                    <a href="#contacto">Contáctenos</a>
                </li>
                <!--
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Portfolio <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="portfolio-1-col.html">1 Column Portfolio</a>
                        </li>
                        <li>
                            <a href="portfolio-2-col.html">2 Column Portfolio</a>
                        </li>
                        <li>
                            <a href="portfolio-3-col.html">3 Column Portfolio</a>
                        </li>
                        <li>
                            <a href="portfolio-4-col.html">4 Column Portfolio</a>
                        </li>
                        <li>
                            <a href="portfolio-item.html">Single Portfolio Item</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="blog-home-1.html">Blog Home 1</a>
                        </li>
                        <li>
                            <a href="blog-home-2.html">Blog Home 2</a>
                        </li>
                        <li>
                            <a href="blog-post.html">Blog Post</a>
                        </li>
                    </ul>
                </li>
                -->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Iniciar Sesión<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <form action="util/iniciarSesion.jsp" method="post">
                            <li>
                                <div class="row">
                                    <div class="col-md-10 col-md-offset-1">
                                        <div class="form-group">
                                            <label>Usuario</label>
                                            <input type="text" class="form-control" name="usuario" placeholder="Usuario" />
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="row">
                                    <div class="col-md-10 col-md-offset-1">
                                        <div class="form-group">
                                            <label>Contraseña</label>
                                            <input type="password" class="form-control" name="contra" placeholder="Contraseña"/>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li><div class="row">
                                    <div class="col-md-10 col-md-offset-1">
                                        <button type="submit" value="Iniciar" id="inicioSesion" class="btn btn-success">Iniciar</button>
                                    </div>
                                </div>
                            </li>
                        </form>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
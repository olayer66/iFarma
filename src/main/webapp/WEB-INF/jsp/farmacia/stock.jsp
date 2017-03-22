<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/headerFarmacia.jspf" %>


<%@ include file="../../jspf/navbarFarmacia.jspf" %>

  <div class="container">
          <!-- ________________TABLE: STOOOOOOCKS___________________________ -->
        
          <div id="stock">
            <div>
              <h2>Tabla de stock</h2>
            </div>
            <!-- /.box-header -->
            <div>
              <table id="tablaStock" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Nombre del medicamento</th>
                  <th>Descripción</th>
                  <th>Nº Dosis por caja </th>
                  <th>Cantidad en stock</th>
                  <th>Precio</th>
                  <th>Añadir stock</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td>Trident</td>
                  <td>Internet
                    Explorer 4.0
                  </td>
                  <td>Win 95+</td>
                  <td> 4</td>
                  <td>X</td>
                   <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td>
                </tr>
                <tr>
                  <td>Trident</td>
                  <td>Internet
                    Explorer 5.0
                  </td>
                  <td>Win 95+</td>
                  <td>5</td>
                  <td>C</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td>                  
                </tr>
                <tr>
                  <td>Trident</td>
                  <td>Internet
                    Explorer 5.5
                  </td>
                  <td>Win 95+</td>
                  <td>5.5</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td>                  
                </tr>
                <tr>
                  <td>Trident</td>
                  <td>Internet
                    Explorer 6
                  </td>
                  <td>Win 98+</td>
                  <td>6</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Trident</td>
                  <td>Internet Explorer 7</td>
                  <td>Win XP SP2+</td>
                  <td>7</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Trident</td>
                  <td>AOL browser (AOL desktop)</td>
                  <td>Win XP</td>
                  <td>6</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Firefox 1.0</td>
                  <td>Win 98+ / OSX.2+</td>
                  <td>1.7</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>            
                <tr>
                  <td>Gecko</td>
                  <td>Firefox 2.0</td>
                  <td>Win 98+ / OSX.2+</td>
                  <td>1.8</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Firefox 3.0</td>
                  <td>Win 2k+ / OSX.3+</td>
                  <td>1.9</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Camino 1.0</td>
                  <td>OSX.2+</td>
                  <td>1.8</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Camino 1.5</td>
                  <td>OSX.3+</td>
                  <td>1.8</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Netscape 7.2</td>
                  <td>Win 95+ / Mac OS 8.6-9.2</td>
                  <td>1.7</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Netscape Browser 8</td>
                  <td>Win 98SE+</td>
                  <td>1.7</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Netscape Navigator 9</td>
                  <td>Win 98+ / OSX.2+</td>
                  <td>1.8</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Mozilla 1.0</td>
                  <td>Win 95+ / OSX.1+</td>
                  <td>1</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Mozilla 1.1</td>
                  <td>Win 95+ / OSX.1+</td>
                  <td>1.1</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Mozilla 1.2</td>
                  <td>Win 95+ / OSX.1+</td>
                  <td>1.2</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Mozilla 1.3</td>
                  <td>Win 95+ / OSX.1+</td>
                  <td>1.3</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Mozilla 1.4</td>
                  <td>Win 95+ / OSX.1+</td>
                  <td>1.4</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Mozilla 1.5</td>
                  <td>Win 95+ / OSX.1+</td>
                  <td>1.5</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Mozilla 1.6</td>
                  <td>Win 95+ / OSX.1+</td>
                  <td>1.6</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Mozilla 1.7</td>
                  <td>Win 98+ / OSX.1+</td>
                  <td>1.7</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Mozilla 1.8</td>
                  <td>Win 98+ / OSX.1+</td>
                  <td>1.8</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Seamonkey 1.1</td>
                  <td>Win 98+ / OSX.2+</td>
                  <td>1.8</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Gecko</td>
                  <td>Epiphany 2.20</td>
                  <td>Gnome</td>
                  <td>1.8</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Webkit</td>
                  <td>Safari 1.2</td>
                  <td>OSX.3</td>
                  <td>125.5</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Webkit</td>
                  <td>Safari 1.3</td>
                  <td>OSX.3</td>
                  <td>312.8</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Webkit</td>
                  <td>Safari 2.0</td>
                  <td>OSX.4+</td>
                  <td>419.3</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Webkit</td>
                  <td>Safari 3.0</td>
                  <td>OSX.4+</td>
                  <td>522.1</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Webkit</td>
                  <td>OmniWeb 5.5</td>
                  <td>OSX.4+</td>
                  <td>420</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Webkit</td>
                  <td>iPod Touch / iPhone</td>
                  <td>iPod</td>
                  <td>420.1</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Webkit</td>
                  <td>S60</td>
                  <td>S60</td>
                  <td>413</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Presto</td>
                  <td>Opera 7.0</td>
                  <td>Win 95+ / OSX.1+</td>
                  <td>-</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Presto</td>
                  <td>Opera 7.5</td>
                  <td>Win 95+ / OSX.2+</td>
                  <td>-</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Presto</td>
                  <td>Opera 8.0</td>
                  <td>Win 95+ / OSX.2+</td>
                  <td>-</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Presto</td>
                  <td>Opera 8.5</td>
                  <td>Win 95+ / OSX.2+</td>
                  <td>-</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Presto</td>
                  <td>Opera 9.0</td>
                  <td>Win 95+ / OSX.3+</td>
                  <td>-</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Presto</td>
                  <td>Opera 9.2</td>
                  <td>Win 88+ / OSX.3+</td>
                  <td>-</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Presto</td>
                  <td>Opera 9.5</td>
                  <td>Win 88+ / OSX.3+</td>
                  <td>-</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Presto</td>
                  <td>Opera for Wii</td>
                  <td>Wii</td>
                  <td>-</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Presto</td>
                  <td>Nokia N800</td>
                  <td>N800</td>
                  <td>-</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Presto</td>
                  <td>Nintendo DS browser</td>
                  <td>Nintendo DS</td>
                  <td>8.5</td>
                  <td>C/A<sup>1</sup></td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>KHTML</td>
                  <td>Konqureror 3.1</td>
                  <td>KDE 3.1</td>
                  <td>3.1</td>
                  <td>C</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>KHTML</td>
                  <td>Konqureror 3.3</td>
                  <td>KDE 3.3</td>
                  <td>3.3</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>KHTML</td>
                  <td>Konqureror 3.5</td>
                  <td>KDE 3.5</td>
                  <td>3.5</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Tasman</td>
                  <td>Internet Explorer 4.5</td>
                  <td>Mac OS 8-9</td>
                  <td>-</td>
                  <td>X</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Tasman</td>
                  <td>Internet Explorer 5.1</td>
                  <td>Mac OS 7.6-9</td>
                  <td>1</td>
                  <td>C</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Tasman</td>
                  <td>Internet Explorer 5.2</td>
                  <td>Mac OS 8-X</td>
                  <td>1</td>
                  <td>C</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Misc</td>
                  <td>NetFront 3.1</td>
                  <td>Embedded devices</td>
                  <td>-</td>
                  <td>C</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Misc</td>
                  <td>NetFront 3.4</td>
                  <td>Embedded devices</td>
                  <td>-</td>
                  <td>A</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Misc</td>
                  <td>Dillo 0.8</td>
                  <td>Embedded devices</td>
                  <td>-</td>
                  <td>X</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Misc</td>
                  <td>Links</td>
                  <td>Text only</td>
                  <td>-</td>
                  <td>X</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Misc</td>
                  <td>Lynx</td>
                  <td>Text only</td>
                  <td>-</td>
                  <td>X</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Misc</td>
                  <td>IE Mobile</td>
                  <td>Windows Mobile 6</td>
                  <td>-</td>
                  <td>C</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Misc</td>
                  <td>PSP browser</td>
                  <td>PSP</td>
                  <td>-</td>
                  <td>C</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                <tr>
                  <td>Other browsers</td>
                  <td>All others</td>
                  <td>-</td>
                  <td>-</td>
                  <td>U</td>
                  <td><div class="input-group input-group-sm">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                     <button type="button" class="btn btn-info btn-flat">Añadir</button>
                    </span>
                    </div>
                   </td> 
                </tr>
                </tbody>
              </table>
              <!-- fin tabla stock -->
                <div>
                    <h2>Añadir nuevos productos:</h2>
                  <ul class="nav nav-pills">
                    <li><a data-toggle="pill" href="#añadirMedicamentoManual">Añadir Medicamento Manualmente</a></li>
                    <li><a data-toggle="pill" href="#añadirMedicamentoarchivo">Añadir medicamentos desde archivo</a></li>
                  </ul>

                  <div class="tab-content">  
                    <div id="añadirMedicamentoManual" class="tab-pane fade">
                      <h3>Añadir Medicamento Manualmente</h3>
                        <!-- nuevo producto-->
                        <div>
                            <div class="col-lg-12">
                                <h3 class="page-header">Nuevo Producto:</h3>
                                <h3><small>Rellene el siguiente formulario.</small></h3>
                            </div>
                            <form>
                                <!--Datos del usuario-->
                                <div class="col-md-6 portfolio-item">
                                    <div class="form-group">
                                        <label for="nombreMedicamento">Nombre del medicamento:</label>
                                        <input type="text" class="form-control" id="nombreMedicamento">
                                    </div>
                                    <div class="form-group">
                                        <label for="descripcionMedicamento">Descripcion</label>
                                        <input type="text" class="form-control" id="descripcionMedicamento">
                                    </div>
                                    <div class="form-group">
                                        <label for="dosisMedicamento">Numero de dosis por caja:</label>
                                        <input type="text" class="form-control" id="dosisMedicamento">
                                    </div>
                                    <div class="form-group">
                                        <label for="cantidadMedicamento">Cantidad en stock:</label>
                                        <input type="text" class="form-control" id="cantidadMedicamento">
                                    </div>
                                    <div class="form-group">
                                        <label for="precioMedicamento">Precio:</label>
                                        <input type="text" class="form-control" id="precioMedicamento">
                                    </div>
                                </div>              
                                <div class="col-md-12 portfolio-item">
                                    <input type="submit" class="btn-lg btn-default center-block" value="Añadir">
                                </div>
                            </form>        
                        </div>
                    </div>
                    <div id="añadirMedicamentoarchivo" class="tab-pane fade">
                      <h3>Añadir Stock desde archivo</h3>
                      <!-- importar desde archivo -->
                        <div class="form-group">
                          <label for="exampleInputFile">Importar:</label>
                          <input type="file" id="exampleInputFile">

                          <p class="help-block">Importar stock desde archivo, 
                           este stock sustituirá por completo al actual</p>
                        </div>
                    </div>
                  </div>
                </div>
               <!-- fin añadir prpductos -->
            </div>
            <!-- /.box-body -->
           </div>
          <!-- tab -->
          </div>
          <!--row-->
         </div>
		</div>
        
           <!-- ________________TABLE: STOOOOOOCKS END___________________________ -->
        
        <hr>

<%@ include file="../../jspf/footerFarmacia.jspf" %>

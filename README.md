# dajw-ingenieria-de-software-para-aplicaciones-moviles


# Music Album 

Este proyecto contiene el codigo fuente de la aplicacion de android

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

Para poder ejecutar de manera correcta el proyecto debe tener configurado las siguientes herramientas en su maquina

```
Node,              Version  12.17.0
Cypress,           Version  7.2.0
Chrome,            Version  90.0.4430.93
Git,               Version  2.21.0
Ghost ,            Version  3.3.0
Kraken,            Version  1.0.9  
ADB Android ,      Version  30.0.5-6877874   
ChromeDriver       Version  ChromeDriver 90.0.4430.24
Java               Version  1.8.0_91
Rubby              Version  ruby 2.6.7p197
Android studio     Version  ArticFox
Chromium           Version  92.0.4499.0
```

### Instalación 🔧

En este caso para ejecutar el proyecto debe haber instalado las herramientas indicadas anteriormente en el paso de **Pre-requisitos**, una vez instaladas debe ejecutar lo siguiente 

Pasos

```
Revisar que se encuentre configurado node de manera correcta, se realiza de la siguiente manera
```

* Abrir la terminal de su equipo, esta guia estara para un sistema operativo Windows, pero si configuro de manera exitosa las herramientas nombradas en  **Pre-requisitos** no deberia haber diferencia.

![Terminal](https://user-images.githubusercontent.com/78820446/117479939-8cc0dd80-af26-11eb-85a5-b3559aa18ac5.PNG)


* Ejecutar el comando node -v en la terminal, si aparece la version  esto indicaria que se encuentre instalado de manera correcta, en caso contrario debera revisar la instalacion de node en su maquina 

![Node ](https://user-images.githubusercontent.com/78820446/117480756-9eef4b80-af27-11eb-98bd-cb7756ef43ac.PNG)


El siguiente paso 

```
Revisar que se encuentre configurado cypress de manera correcta, se realiza de la siguiente manera
```

* Abrir la terminal de su equipo, puede ser la misma que abrio en el paso anterior para verificar  la instalacion de node

![Terminal](https://user-images.githubusercontent.com/78820446/117479939-8cc0dd80-af26-11eb-85a5-b3559aa18ac5.PNG)

* Ahora ejecutar el siguiente comando **Cypress -v**, en caso que no aparesca las versiones en cada campo deberia revisar la instalacion del cypress

![Cypress version](https://user-images.githubusercontent.com/78820446/117480168-dd383b00-af26-11eb-84f1-c3ef654e1a8a.PNG)


El siguiente paso 

```
Revisar que tenga instalado git en su maquina, se realiza de la siguiente manera
```

* Abrir la terminal de su equipo, puede ser la misma que abrio en el paso anterior para verificar  la instalacion de node

![Terminal](https://user-images.githubusercontent.com/78820446/117479939-8cc0dd80-af26-11eb-85a5-b3559aa18ac5.PNG)

* Ahora ejecutar el siguiente comando **git --version**, en caso que no aparesca la version debera revisar la instalacion de git

![git](https://user-images.githubusercontent.com/78820446/117470240-351d7480-af1c-11eb-9032-03f81b674975.PNG)



El siguiente paso

```
Revisar que tenga instalado ruby de manera correcta
```

* Sobre la terminal ejecutada debe ejecutar el siguiente comando **ruby -v**, en caso que no aparesca la version debera revisar la instalacion de **ruby**

![ruby](https://user-images.githubusercontent.com/78820446/117545809-028f7c80-afed-11eb-9e57-9ce0ac6c87d5.PNG)



El siguiente paso

```
Revisar que tenga instalado java  y configurado 
```

* Sobre la terminal ejecutada debe ejecutar el siguiente comando **java  -version** en caso que no aparesca la version deberia revisar la instalacion 

![Java](https://user-images.githubusercontent.com/78820446/117546069-2ef7c880-afee-11eb-9eda-64cd2bdd8a10.PNG)

* Si se reconoce el comando **java -version** debera configurar las siguientes variables de entorno en el computador 

  - JAVA_HOME Ingresar la ruta donde se encuentra instalado su JDK 

![JAVA ENTORNO](https://user-images.githubusercontent.com/78820446/117546738-80558700-aff1-11eb-85c4-91102e2994dd.PNG)

  - Adicional agregar las siguientes variables de entorno en la opcion de **path**:  **%JAVA_HOME%\bin** 

![JAVA ENTORNO](https://user-images.githubusercontent.com/78820446/117546768-b72b9d00-aff1-11eb-9bc9-324525a90433.PNG)




El siguiente paso

```
Revisar que tenga configurado adb de manera correcta y se reconozca el comando por la terminal 

```

* Sobre la terminal ejecutada debe ejecutar el siguiente comando **adb --version** en caso que no aparesca la version deberia revisar la instalacion 


![ab](https://user-images.githubusercontent.com/78820446/117546179-cc52fc80-afee-11eb-9788-d93a68e83aa5.PNG)

* Si se encuentra configurado el **adb** de manera correcta deberan configurar las siguientes variables de entorno adicionales para el correcto funcionamiento

  - ANDROID_HOME
  
![Android  sdk](https://user-images.githubusercontent.com/78820446/117546292-54d19d00-afef-11eb-93b4-9197aa4e9880.PNG)

![SDK configuracion](https://user-images.githubusercontent.com/78820446/117546341-93675780-afef-11eb-959a-6c230f0e6253.PNG)

  - Adicional agregar las siguientes variables de entorno en la opcion de **path**:  **%ANDROID_HOME%\tools** **%ANDROID_HOME%\tools\bin** **C:\Users\wilso\AppData\Local\Android\Sdk\platform-tools poner la ruta de su SDK** 

![entorno](https://user-images.githubusercontent.com/78820446/117546536-7da66200-aff0-11eb-804c-8101510b99b9.png)


El siguiente paso 


```
Clonar el repositorio a traves de git siguiendo los siguientes pasos 
```

* Crear una carpeta vacia en cualquier ubicacion de su equipo, es importante que no contenga espacios en blanco 
 
* Abrir la terminal y ubicarse en la ruta donde se encuentra creada la carpeta a traves de la terminal 


* Clonar el repositorio a traves del siguiente commando  **git clone https://github.com/wilson1234567891962/dajw-ingenieria-de-software-para-aplicaciones-moviles.git**

![git](https://user-images.githubusercontent.com/78820446/117548460-c7944580-affa-11eb-87bd-e5e574837e68.PNG)



El siguiente paso 


```
Dirigirse a  la carpeta clonada con la terminal del paso anterior 
```

* Sobre la carpeta creada en el paso anterior y el proyecto clonado, debe ejecutarse el siguiente comando **cd dajw-ingenieria-de-software-para-aplicaciones-moviles/**

![Captura](https://user-images.githubusercontent.com/33532595/140616455-b1ab21e2-d646-410b-a6ff-b103cf6c5361.JPG)


* Ahora una ves clonado el repositorio, vamos abrir el proyecto con android studio es importante que sea la version indica **Fox**

**Imagen de visualizacion de android**

![Captura](https://user-images.githubusercontent.com/33532595/140616497-0d368124-e521-4bab-91fb-5ef1265375cf.JPG)

**Imagen para abrir el proyecto**

![Captura](https://user-images.githubusercontent.com/33532595/140616525-140baddb-ece6-4e0e-b428-abc8be708502.JPG)

Ahora va empezar a sincronizar el proyecto debemos esperar que termine el proceso

![Captura](https://user-images.githubusercontent.com/33532595/140616568-039a190d-9e9c-4918-a8cb-f6fbbf005a42.JPG)

Por ultimo vamos a crear un emulador  superior o igual a la version 21 de android studio. En el siguiente enlace se explica como crear un emulador u correr la app. https://developer.android.com/studio/run/emulator

## Video para correr el proyecto 🚗

En siguiente video encontrara una breve explicacion de cuales seran los pasos para correr el proyecto 

https://uniandes-my.sharepoint.com/:v:/g/personal/w_gonzalezg_uniandes_edu_co/EZIyjgvk20xIv9iHBL6-nP4BbgVWOHdO_4pgb8wX8lDzPQ?e=btearI


## Funcionalidades y estrategias 🚗

Este proyecto está probando las siguientes funcionalidades:

1. Manage Pages:
    - Iniciar sesión en Ghost ir a post, filtar unicamente por la opcion de concepto
    - Iniciar sesión en Ghost ir a post, filtar unicamente por concepto y autor ghost
    - Iniciar sesión en Ghost ir a post, filtar unicamente por concepto, autor y tag
    - Iniciar sesión en Ghost ir a post, filtar unicamente por concepto, autor,  tag y publicacion reciente
3. Manage General Settings:
    - Iniciar sesión en Ghost ir a configuraciones generales y editar el título y la descripción del sitio.
    - Iniciar sesión en Ghost ir a configuraciones generales y editar la zona horaria del sitio.
    - Iniciar sesión en Ghost ir a configuraciones generales y poner el sitio como privado.
    - Iniciar sesión en Ghost ir a configuraciones generales y editar el campo de lenguage del sitio.
4. Manage Login:
    - Login con usuario y contraseña incorrectos
    - Login con usuario y contraseña correctos
    - Login con usuario correcto y contraseña incorrecta
    - Login con usuario incorrecto y contraseña correcta
 4. Create Posts:
    - Creación de post usando el botón "+" desde home
    - Creación de post usando el botón "New post" desde listado de posts
    - Creación de post con estado published usando el botón "New Post" desde listado de post
    - Creación de post con estado scheduled usando el botón "New Post" desde listado de post
 5. Manage Tags:
    - Iniciar sesión en Ghost ir a tags, crear un nuevo tag con nombre y descripción
    - Iniciar sesión en Ghost ir a tags, editar el nombre de un tag existente
    - Iniciar sesión en Ghost ir a tags, agregar metadata y descripción de metadata a un tag existente
    - Iniciar sesión en Ghost ir a tags, eliminar un tag existente

# Ejecutando pruebas E2E sobre Ghost 3.3.0 ⚙️

Para ejecutar unicamente debe  hacer lo siguiente:

1. **Para ejecutar las pruebas de la versión Ghost 3.3.0** debe ejecutar el comando **git checkout Ghost3.3.0**
2. Asegurese de haber inicializado ghost en la versión 3.3.0
3. Luego deberá modificar las variables **USER** y **PASSWORD** en el archivo **kraken_mobile_properties.json**, que está ubicado dentro de la carpeta **proyecto**, con sus credenciales registradas en Ghost 3.3.0. **Por ejemplo:

    **"USER":"arodriguezt9509@gmail.com",**
 
    **"PASSWORD":"********"
      
4. Asegurese de tener la vista del sitio como **pública**. Para esto debe ir a "General Settings" en Ghost y en la sección "Advanced Settings" debe tener deshabilitada la opción de "Make this site private", como se observa a continuación.

5. Por último, ejecute el siguiente comando: **bundle exec kraken-mobile run --properties=./kraken_mobile_properties.json**, en este caso si realizo las configuraciones de una manera correcta deberán empezar a ejecutarse los tests, en caso contrario deberaá revisar alguno de los pasos de instalación. 

# Ejecutando pruebas E2E sobre Ghost 3.42.5 ⚙️

Para ejecutar unicamente debe  hacer lo siguiente:

1. **Para ejecutar las pruebas de la versión Ghost 3.42.5** debe ejecutar el comando **git checkout Ghost3.42.5**
2. Asegurese de haber inicializado Ghost en la versión 3.42.5
3. Luego deberá modificar las variables **USER** y **PASSWORD** en el archivo **kraken_mobile_properties.json**, ue está ubicado dentro de la carpeta **proyecto**, con sus credenciales registradas en Ghost 3.42.5. **Por ejemplo:

    **"USER":"arodriguezt9509@gmail.com",**
 
    **"PASSWORD":"********"
    
4.  Asegurese de tener la vista del sitio como **pública**. Para esto debe ir a "General Settings" en Ghost y en la sección "Advanced Settings" debe tener deshabilitada la opción de "Make this site private", como se observa a continuación.

![image](https://user-images.githubusercontent.com/78829003/117516478-d75e4c00-af5e-11eb-8002-3ff61f2e25d6.png)

5. Por último, ejecute el siguiente comando: **bundle exec kraken-mobile run --properties=./kraken_mobile_properties.json**, en este caso si realizo las configuraciones de una manera correcta deberán empezar a ejecutarse los tests, en caso contrario deberaá revisar alguno de los pasos de instalación. 


### Analice las pruebas end-to-end 🔩

En este caso para el analizis de las pruebas ejecutadas unicamente debe evidenciar los resultados de la consola y ver los resultados en la carpeta **JWDA-Kraken-Semana5\proyecto\reports**

# Ejecutando VRT con Resemble.js ⚙️

Para ejecutar debe  hacer lo siguiente:

1. **Para ejecutar VRT en Resemble.js** debe ejecutar el comando **git checkout Resemble/Semana6**
2. Luego de moverse a la rama Resemble/Semana6 debe ir a la carpeta **resemble** ejecutando el siguiente comando **cd resemble**
3. Allí deberá ejecutar el comando **npm install**
4. En el archivo **index.js** que se encuentra dentro de la carpeta **resemble** deberá modificar el path que contiene a la carpeta **resemble**, como se indica en la siguiente imagen:

![image](https://user-images.githubusercontent.com/78829003/118384661-7f15f280-b5cd-11eb-8467-f3b1a93bc2b5.png)
5. Para ejecutar el vrt para cada uno de los escenarios deberá modificar la variable **scenario** y la variable **steps**, teniendo en cuenta lo siguiente:

![image](https://user-images.githubusercontent.com/78829003/118384817-d6689280-b5ce-11eb-90d3-2f21376cf51e.png)

|Scenario|Steps|
|--------|-----|
|Login_invalid_user_invalid_pass|6|
|Login_invalid_user_valid_pass|6|
|Manage_settings_change_timezone|10|
|Manage_settings_make_private|9|
|Pages_filter_by_item_1st|11|
|Pages_filter_by_item_1st_to_4th|17|
|Post_creation_new_post_button|13|
|Post_creation_scheduled|19|
|Tag_manage_add_metadata|16|
|Tag_manage_delete_tag|13|


6. Luego de modificar las variables anteriores, deberá ejecutar el comando **node index.js** lo cual le creará una carpeta dentro de la carpeta **results** con el nombre del escenario ejecutado. Dentro de esta carpeta encontrará las imágenes del resultado de las comparaciones realizadas paso a paso y el reporte de cada una de estas comparaciones, igualmente por cada paso.

![image](https://user-images.githubusercontent.com/78829003/118384703-ecc21e80-b5cd-11eb-8b9c-41c7bc78ceef.png)

### Analice el vrt con Resemble🔩

Para cada uno de los escenarios ejecutados, encontrará dentro de la carpeta **results** una carpeta con el nombre del escenario. Dentro de esta carpeta podrá visualizar las imágenes del resultado de la comparación de cada uno de los pasos ejecutados en el escenario para Ghost 3.3.0 y Ghost 3.42.5. Igualmente podrá visualizar un reporte que le mostrará la imagen del paso ejecutado en Ghost 3.3.0, la imagen del paso ejecutado en Ghost 3.42.5 y las diferencias entre estas dos imágenes:

![image](https://user-images.githubusercontent.com/78829003/118384789-973a4180-b5ce-11eb-83c6-55d8c6132bd2.png)

# Ejecutando VRT con Backstop.js ⚙️

Para ejecutar debe  hacer lo siguiente:

1. **Para ejecutar VRT en Resemble.js** debe descargar la CLI. Para esto abra una terminal y ejecute el comando **npm install -g backstopjs**
2. Luego debe moverse a la rama  Backstop/Semana6  ejecutando el comando **git checkout Backstop/Semana6** 
3. Luego de moverse a la rama  Backstop/Semana6 debe ir a la carpeta **backstop** ejecutando el siguiente comando **cd backstop**
4. Allí deberá ejecutar el comando **backstop test**
5. Esto le abrirá una ventana en el browser que le mostrará el resultado para cada uno de los pasos del escenario Login with invalid user and valid password.

### Analice el vrt con Backstop 🔩

Luego de ejecutar el comando backstop test se le abrirá automaticamente una nueva ventana en el browser la cual mostrará el reporte con los resultados obtenidos. Para cada uno de los pasos del escenario se mostrará la imagen de referencia, la imagen de test y la imagen con las diferencias. Estos resultados se mostrán para dos tipos de pantallas.

![image](https://user-images.githubusercontent.com/78829003/118386658-ab863a80-b5de-11eb-8deb-614b6a3645d8.png)

# Ejecutando pruebas E2E con pool de datos pseudo-aleatorio dinámico sobre Ghost 3.42.5 ⚙️

Para ejecutar las pruebas e2e con pool de datos pseudo-aleatorio dinámico estamos usando la herramienta **Mockaroo** y un script en **Python3** llamado **readmockaroo.py**. El script se encarga de generar los datos pseudo-aleatorios antes que se realicen las pruebas. Como requisito se debe tener installado **[Python3](https://www.python.org/downloads/)** y la librería de python **[requests](https://pypi.org/project/requests/)**. 

1. **Para ejecutar las pruebas con pool de datos pseudo-aleatorio dinámico sobre la versión Ghost 3.42.5** debe ejecutar el comando **git checkout feature/jb_pool_mockaroo**
2. Asegurese de haber inicializado Ghost en la versión 3.42.5
3. Moverse a la carpeta proyecto con el siguiente comando **cd proyecto**
4. Luego deberá modificar las variables **USER** y **PASSWORD** en el archivo **credentials.json**, que está ubicado en la carpeta **proyecto**, con sus credenciales registradas en Ghost 3.42.5. **Por ejemplo:

    **"USER":"prueba@gmail.com",**
 
    **"PASSWORD":"********"
      
5. Genere los datos pseudo-aleatorios con el siguiente comando **python3 readmockaroo.py**
6. Luego de ejecutado el script podrá verificar que el archivo **kraken_properties_mockaroo.json** se ha modificado con sus credenciales y otras variables que tienen valores aleatorios generados en **Mockaroo** que se usarán en las pruebas.  
7. Por último, ejecute el siguiente comando: **bundle exec kraken-mobile run --properties=./kraken_properties_mockaroo.json**, en este caso si realizo las configuraciones de una manera correcta deberán empezar a ejecutarse los tests, en caso contrario deberá revisar alguno de los pasos de instalación. 
8. Si desea, puede actualizar el pool de datos corriendo nuevamente el script de python para realizar las pruebas con nuevos datos

En caso de que alguno de los escenarios de prueba falle, puede deberse a que en la generación de datos con **Mockaroo** a algunas de las variables hemos configurado para que en un 20% de las veces genere datos NULL.

## Pasos para ejecutar el Generador.jar para las pruebas E2E sobre Ghost 3.42.5: Este tiene cubrimientos para generar  los diferentes tipos de datos **Prioriatio, Complemento del pseudo y aleatorio**

* Clonar el repositorio **https://github.com/Alejito29/JWDA-Kraken-Semana5**

* Ubicarse en la rama **feature/ag_kraken_data**

* Abrir el ejecutable **Generador.jar** que se encuentra en la raiz del proyecto, en caso de ser sistema operativo linux debe ejecutarlo con la terminal, si es mac o windows unicamente debe darle doble click, como requisito es necesario que tenga instalado JAVA  1.7.

![Evidenica jar2](https://user-images.githubusercontent.com/78820446/119274217-70829900-bbd4-11eb-989e-1825cb0150da.png)


* Por ultimo debe escoger el nombre del test, cuantas veces se va repetir la creacion y que tipo de dato desea. Con el jar podra crear diferentes tipos de datos, en este caso usted define cuanto dataset desea generar, aunque si genera el maximo cubriria los casos solicitados solo que se demoraria la ejecucion.

 ![Evidenica jar](https://user-images.githubusercontent.com/78820446/119274137-1bdf1e00-bbd4-11eb-9f1e-ab7cb971bb13.png)

Observacion en la wiki se encuentra el detalle tecnico como ejecutar cada prueba con los diferentes tipos de datos 

* https://github.com/Alejito29/JWDA-Kraken-Semana5/wiki/Pool-de-datos-Apriori
* https://github.com/Alejito29/JWDA-Kraken-Semana5/wiki/Pool-de-datos-pseudo-aleatorio-din%C3%A1mico
* https://github.com/Alejito29/JWDA-Kraken-Semana5/wiki/Aleatorio

Adicional en caso que desen tener acceso al fuente del codigo java lo encontraran aca **https://github.com/Alejito29/JWDA-Java-Semana7**

## Video de explicacion para ejecutar el Generador.jar 

En este enlace podrán encontrar un pequeño video donde explicamos la forma de  generar los datos antes de ejecutar los test de las diferentes formas

https://uniandes-my.sharepoint.com/:v:/g/personal/w_gonzalezg_uniandes_edu_co/ETYtwFw3lEFLjWN-SzKbImQBu4IktCsbP3a2f1IC2nfqHw?e=L7I2kB


### Analice las pruebas end-to-end con  los diferentes tipos de datos 🔩

En este caso para el analizis de las pruebas ejecutadas unicamente debe evidenciar los logs de la consola y ver los resultados en la carpeta **JWDA-Kraken-Semana5\proyecto\reports**

**NOTA: La descripción de la estrategia usada para la generación de datos y la definición de los oráculos, la puede encontrar como una página en la wiki de este repositorio.**


## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Node 12.17.0](https://nodejs.org/es/download/releases/) - Node
* [Cypress](https://www.cypress.io/) - Cypress
* [Android studio](https://developer.android.com/studio) - Android
* [Chromium](https://www.chromium.org/getting-involved/download-chromium) - Chromium
* [JAVA](https://www.java.com/es/download/ie_manual.jsp) - Java
* [Kraken](https://github.com/TheSoftwareDesignLab/KrakenMobile/archive/refs/tags/1.0.9.zip.) - Kraken
* [Chrome](https://www.google.com/intl/es/chrome/?brand=UUXU&gclid=CjwKCAjw7diEBhB-EiwAskVi10CI0gLPlO0E3zn_0-3gOnt60O2j_i2Jr_gHLJIEkfyP0JssFBki4hoC4sYQAvD_BwE&gclsrc=aw.ds) - Chrome
* [Javascript](https://developer.mozilla.org/es/docs/Web/JavaScript) - Javascript
* [Git](https://git-scm.com/downloads) - Git
* [Ghost](https://github.com/TryGhost/Ghost/tree/3.3.0) - Ghost
* [Chromedriver](https://chromedriver.chromium.org/downloads) - chromedriver
* [Ruby](https://rubyinstaller.org/) - Ruby

## Autores ✒️

_Autor_

* **Wilson Alejandro Gonzalez Gaitan** - *Trabajo Inicial* - [Alejito29](https://github.com/Alejito29)
* **Dario Fernando Herrera Gonzalez** - *Trabajo Inicial* - [dherrera54](https://github.com/dherrera54)
* **Angelica Maria Rodriguez Torres** - *Trabajo Inicial* - [angelicamariarodriguez](https://github.com/angelicamariarodriguez9)
* **Jorge Ivan Barrera Rea** - *Trabajo Inicial* - [ivanbrij](https://github.com/ivanbrij)




## Licencia 📄

Este proyecto está bajo la Licencia (Copyleft) - mira el archivo [LICENSE.md](LICENSE.md) para detalles



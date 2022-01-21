# testAutomationProjectFravega
Test Automation Project with 3 testcases in de webpage fravega.com

#Requirements of Chanllege

Test Frontend:

- Realizar un único test donde se realicen los pasos abajo mencionados y se incluya en dicho test las aserciones
indicadas en el punto 6.

Pasos:

1- Generar una clase, con un método de test que instancie un chromedriver.

2- Ingrese a la home de Frávega (www.fravega.com).

3- Busque "Heladera".

4- Filtre por "Heladeras" desde los filtros de la sección izquierda de la página.

5- Filtre por la primer marca desde los filtros "Marca" de la sección izquierda de la página.

Assert:

6- Guarde la grilla de resultados como lista de WebElement y aserte que:

- Cada uno de los elementos contenga en su title la marca filtrada.
- La cantidad de elementos de la lista coincida con los resultados mostrandos por el frontend.
- Que en el breadcrumb de la página (atributo name="breadcrumb") se encuentre la palabra "Heladeras"

El test debe heredar de una clase base (TestBase) donde deben estar los annotation @BeforeTest y @AfterTest.

Es deseable utilizar el patrón "Page Object" para el modelado de las páginas.

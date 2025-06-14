# Repartir Frontend


## Setup del ambiente:


Disponibilizar `node v22.13.0` en `NODE_PATH` 

```
export PATH=${NODE_PATH}/bin:${PATH}
```

Instalar angular

```
npm install -g @angular/cli@16.2.12
```

Instalar drivers para playright

```
npx playwright@1.48.1 install
```

Si devuelve un error por dependencias, ejecutar

```
npx playwright install-deps
```

## Iniciar

```
npm install
npm run build
npm run start
```

## Ejecutar pruebas de aceptación JS implementadas con Playwright

__Precondición__

Antes de ejecutar los test de aceptación es necesario instalar los browsers que va a utilizar Playwright:

```
npx -y playwright@1.48.1 install --with-deps
```

*Nota: La versión usada en este comando debe __coincidir__ con la versión definida en el package.json*

Para correr los test:

```
npm run acceptance-test
```

Estos tests son de punta a punta. Antes de comenzar a ejecutarse, van a chequear si el backend, el frontend y la API de personas mockeada están levantados y si no lo están, se encarga de levantarlos. 


### Recompilar los escenarios
Se está utilizando el plugin de [Playwright BDD](https://github.com/vitalets/playwright-bdd) para compilar los escenarios escritos en Gherkin en código que Playwright puede ejecutar. Esto permite aprovechar todas las ventajas del runner de Playwright en lugar de utilizar el de cucumberJS.

Como consecuencia, si se modifican los escenarios es necesario recompilar el código generado antes de volver a ejecutar las pruebas. Para hacerlo, ejecutar
```
npx bddgen
```

### Para ejecutar un único escenario

#### Con la interfaz gráfica de Playwright

Levantar la interfaz gráfica de Playwright con (se le pasa alguno de los archivos de configuración dado que no están en el lugar por default)
```
npx playwright test --config ../../jsAcceptanceTest/src/playwright.config.ts --ui
```

También puede hacerse ejecutando alguno de los comandos propios y agregándole el parámetro 'ui'
```
npm run acceptance-test -- --ui
```
Desde ahí se puede elegir qué escenario correr.

Si se desea ver el browser abierto (en lugar de que se ejecute en modo headless), agregar el parámetro --headed a cualquiera de los comandos previos:
```
npx playwright test --config ../../jsAcceptanceTest/src/playwright.config.ts --ui --headed
```


#### Desde la consola

Usar la opción ```--grep```

```
$ npm run acceptance-test -- --grep "Mostrar un mensaje de bienvenida"
```

Consultar [otras opciones que admite Playwright](https://playwright.dev/docs/test-annotations).


## Empaquetar

```
npm run build
```

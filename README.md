# Hello oAuth2 World

A sample spring boot application the shows how to support oAuth2 sso.

## How to run

create an instance of xsuaa service with plan default

```
cf cs xsuaa default xsuaa-default
```

update the application.properties file with the clientId, clientSecret and you UAA url.

build the project

```
mvn clean package
```

push the application to CF

```
cf push
```

you can also run it locally from eclipse with no modifications
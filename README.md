cordova-plugin-acra
===================

What it does
------------
Bundles the Acra client library, and catch all Javascript errors to send them to the server in addition to Java exceptions.

Javascript errors being all seen as the same Java exception, custom fields are included:

```
CUSTOM_DATA -> sourceId
CUSTOM_DATA -> line
CUSTOM_DATA -> message
```

Usage
-----
 * Install the plugin to your Cordova application: `cordova plugin add https://github.com/erwan/cordova-plugin-acra`
 * As the documentation of Acra says, create an Application class with the `ReportsCrashes` annotation with the address to your server

$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/Rediff_Reg.feature");
formatter.feature({
  "name": "Registration",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Registration",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "User is on Rediff Registration page",
  "keyword": "Given "
});
formatter.step({
  "name": "User enters \"\u003cname\u003e\" \"\u003cemail\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "User is Registered successfully",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "user user",
        "user@rediff.com",
        "user@123"
      ]
    },
    {
      "cells": [
        "admin admin",
        "user@rediff1.com",
        "user@173"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Registration",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "User is on Rediff Registration page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinations.Rediff_Reg.user_is_on_Rediff_Registration_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"user user\" \"user@rediff.com\" and \"user@123\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinations.Rediff_Reg.user_enters_and(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is Registered successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinations.Rediff_Reg.user_is_registered_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Registration",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "User is on Rediff Registration page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinations.Rediff_Reg.user_is_on_Rediff_Registration_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"admin admin\" \"user@rediff1.com\" and \"user@173\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinations.Rediff_Reg.user_enters_and(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is Registered successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinations.Rediff_Reg.user_is_registered_successfully()"
});
formatter.result({
  "status": "passed"
});
});
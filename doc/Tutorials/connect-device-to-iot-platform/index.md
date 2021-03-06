---
layout: page
title: How to connect a device
permalink: /:path/
sort_idx: 1
---

{% include variables.md %}
{% include_relative links.md %}

* TOC
{:toc}

In this tutorial we will look at how to connect a simulated device to the Kaa platform using the default, MQTT-based protocol.
You will learn how to create a digital twin of your device, connect it, submit some metadata attributes, and view them in the Kaa web interface.


## Overview

We will simulate a smart energy scenario.
Our [endpoint][endpoint] will act as a smart meter and report its model and MAC address to the Kaa platform.
Also, we will configure an [Endpoint List widget][ep-list-widget] on the [Web Dashboard][WD] to display newly connected endpoint with its reported metadata.

![Architecture overview](attach/img/architecture-overview.svg)


## Prerequisites

1. You understand the Kaa platform [device management basics][identity].
2. The Kaa platform is up and running with the following microservices included:
* [Kaa Protocol Communication (KPC)][KPC];
* [Credential Management (CM)][CM];
* [Endpoint Metadata Extension (EPMX)][EPMX];
* [Endpoint Register (EPR)][EPR];
* [Web Dashboard (WD)][WD].
3. [Python 2.7](https://www.python.org/download/releases/2.7/) is installed on your machine.


## Background information

Kaa platform by default uses an **MQTT-based transport**: the [Kaa Protocol (1/KP)][1/KP].
1/KP acts as a multiplexing protocol and allows running higher level (extension) protocols on top of it.
Extension protocols enable data exchange between endpoints and extensions: microservices that implement different aspects of the server-side functionality, such as **metadata synchronization** ([EPMX][EPMX]), **data collection** ([DCX][DCX]), **configuration management** ([CMX][CMX]), etc.

Managed devices are represented as [endpoints][endpoint] in the Kaa platform.
1/KP uses endpoint tokens (alphanumeric strings) to identify connected endpoints.
Every managed device must have a **separate endpoint token** for communicating with the platform.

Every extension defines its own **MQTT path and payload** structure to be used by endpoints.
In this tutorial we will use only one **extension**, [EPMX][EPMX], that serves for endpoint metadata synchronization.
Check its extension protocol [10/EPMP][10/EPMP] for more information.

Now let's get to the action.


## Playbook

**1**. Go to the Web Dashboard and configure (if it is not already configured) an [Endpoint List widget][ep-list-widget].
Add `meterDescription` field to the endpoint creation form. We will fill it out during the endpoint record creation.

<div align="center">
  <iframe width="640" height="385" src="https://www.youtube.com/embed/qMeLZa0emws?rel=0" frameborder="0"
    allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

**2**. Create an endpoint record and obtain an endpoint token:

<div align="center">
  <iframe width="640" height="385" src="https://www.youtube.com/embed/du7tBJY72xM?rel=0" frameborder="0"
    allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

**3**. Open [client.py](https://repl.it/@KaaIoT/ConnectDeviceToIotPlatform) simulator script, add the `user_host`,`user_port`, `token` and `user_application_version` parameters' values and click the `Run` button. The following logs should be outputted in the sandbox console:

```
INFO: Using endpoint token myToken, server at {host}
DEBUG: Composed metadata topic: kp1/demo_application_v1/epmx/myToken/update/keys
INFO: Connecting to KPC instance at {host}:{port}...
INFO: Successfully connected
INFO: Sent metadata: {"model": "MySmartMeter A300", "mac": "00-14-22-01-23-45"}

INFO: Disconnecting from server at {host}:{port}.
INFO: Successfully disconnected
```

**4**. Go to the Web Dashboard and configure the Endpoint List widget with new metadata columns:

<div align="center">
  <iframe width="640" height="385" src="https://www.youtube.com/embed/ozMnDBzknHQ?rel=0" frameborder="0"
    allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Now our device is listed in the Endpoint List widget along with its metadata:

![Endpoint List](attach/img/endpoint-list.png)


## Resources

All tutorial resources are located on [GitHub][code_url].

## Next steps

- [Device management][identity] - find out more about device management feature.
- [Data collection tutorial][data collection tutorial] - learn how to collect telemetry from your device into the platform.


[ep-list-widget]: {{wd_url}}Widgets/#ep-list
[code_url]: https://github.com/kaaproject/kaa/tree/master/doc/Tutorials/connect-device-to-iot-platform/attach/code

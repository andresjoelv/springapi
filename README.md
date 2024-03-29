# SpringAPI :space_invader:
API using Spring Boot (Java) which allows a client to provide a photo and return metadata (EXIF) contained in the photo.

## Description
The application is served by a web application http://localhost:8080/
Allows a client to provide the photo via an RPC over HTTP with a JSON data interchange.

### Prerequisites
The response payload returns the following structured attributes represented in a JSON object.

* File length :heavy_check_mark:
* Datetime (timestamp) of the photo :heavy_check_mark:
* Dimensions of the photo :heavy_check_mark:
* Description of the photo :heavy_check_mark:

### Third party EXIF library to extract data from photo. :100:

* [metadata extractor](https://github.com/drewnoakes/metadata-extractor) - Extracts Exif, IPTC, XMP, ICC and other metadata from image and video files

## Installation 
Clone this repo to local computer and open with preferred IDE or text editor. Build and run the application
![](installation.gif) 


## Usage
Head to http://localhost:8080/. Click on the **Choose file** button and select an image of your choice and click **Upload**. A JSON object containing the metadata of the image should be displayed.
![](usage.gif)

## Console
Go into your Debug console to see the JSON response formatted.

![console](console.png)

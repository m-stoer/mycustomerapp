package com.company.controller;

import io.micronaut.http.annotation.Controller;
import one.microstream.cluster.nodelibrary.micronaut.StorageClusterController;

@Controller("/microstream")
public class MicroStreamController extends StorageClusterController
{
}

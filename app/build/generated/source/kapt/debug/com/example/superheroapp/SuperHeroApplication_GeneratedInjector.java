package com.example.superheroapp;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = SuperHeroApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface SuperHeroApplication_GeneratedInjector {
  void injectSuperHeroApplication(SuperHeroApplication superHeroApplication);
}

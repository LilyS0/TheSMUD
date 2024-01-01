import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { HeroesComponent } from './heroes/heroes.component';
import { HeroSearchComponent } from './hero-search/hero-search.component';
import { MessagesComponent } from './messages/messages.component';
import { HomescreenComponent } from './homescreen/homescreen.component';
import { PlayChoiceComponent } from './play-choice/play-choice.component';
import { DungeonComponent } from './dungeon/dungeon.component';
import { ArenaComponent } from './arena/arena.component';
import { BackButtonComponent } from './back-button/back-button.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  declarations: [
    AppComponent,
    DashboardComponent,
    HeroesComponent,
    HeroDetailComponent,
    MessagesComponent,
    HeroSearchComponent,
    HomescreenComponent,
    PlayChoiceComponent,
    DungeonComponent,
    ArenaComponent,
    BackButtonComponent
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeroesComponent } from './heroes/heroes.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { HomescreenComponent } from './homescreen/homescreen.component';
import { PlayChoiceComponent } from './play-choice/play-choice.component';
import { DungeonComponent } from './dungeon/dungeon.component';
import { ArenaComponent } from './arena/arena.component';

const routes: Routes = [
  { path: '', redirectTo: '/homescreen', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: HeroDetailComponent },
  { path: 'heroes', component: HeroesComponent },
  { path: 'homescreen', component: HomescreenComponent},
  { path: 'play-choice', component: PlayChoiceComponent},
  { path: 'dungeon', component: DungeonComponent},
  { path: 'arena', component: ArenaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
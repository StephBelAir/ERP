import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule} from "@angular/material/dialog";
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';

import { MachinePageComponent } from './components/machine-page/machine-page.component';
import { ProcessPageComponent } from './components/process-page/process-page.component';
import { LotPageComponent } from './components/lot-page/lot-page.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { MachineDialogComponent } from './components/machine-dialog/machine-dialog.component';


import { RouterModule } from '@angular/router';
import {MatButtonModule} from "@angular/material/button";

// Form ??




@NgModule({
  declarations: [
    AppComponent,
    MachinePageComponent,
    ProcessPageComponent,
    LotPageComponent,
    PageNotFoundComponent,
    MachineDialogComponent

  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: 'machine-page', component: MachinePageComponent},
      {path: 'process-page', component: ProcessPageComponent},
      {path: 'lot-page', component: LotPageComponent},
      {path: '', redirectTo: '/machine-page', pathMatch: 'full'},
      {path: '**', component: PageNotFoundComponent}
    ]),
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

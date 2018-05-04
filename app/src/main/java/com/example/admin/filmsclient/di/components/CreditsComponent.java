package com.example.admin.filmsclient.di.components;

import com.example.admin.filmsclient.di.modules.CreditsModule;
import com.example.admin.filmsclient.di.scope.UserScope;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.pages.credits.CreditsPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {
        CreditsModule.class
})
@UserScope
public interface CreditsComponent {

    CreditsPresenter providePresenter();
}

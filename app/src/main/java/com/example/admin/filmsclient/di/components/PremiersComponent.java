package com.example.admin.filmsclient.di.components;

import com.example.admin.filmsclient.di.modules.PremiersModule;
import com.example.admin.filmsclient.di.scope.UserScope;
import com.example.admin.filmsclient.presentation.mvp.premiers.PremiersPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {
        PremiersModule.class
})
@UserScope
public interface PremiersComponent {

    PremiersPresenter providePresenter();
}

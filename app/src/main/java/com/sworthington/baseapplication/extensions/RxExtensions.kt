package com.sworthington.baseapplication.extensions

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

internal fun Disposable.addTo(disposable: CompositeDisposable) = disposable.add(this)
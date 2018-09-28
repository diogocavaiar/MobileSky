package sky.diogo.com.br.mobiletestsky.ui.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface BaseMvpPresenter<V : BaseView> {

    val isAttached: Boolean

    private val mCompositeDisposable: CompositeDisposable
        get() = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.addAll(disposable)
    }

    fun unsubscribe() {
        mCompositeDisposable.clear()
    }

    fun attach(view: V)

    fun detach()
}
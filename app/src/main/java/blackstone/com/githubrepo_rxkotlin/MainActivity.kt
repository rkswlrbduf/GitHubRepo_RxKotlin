package blackstone.com.githubrepo_rxkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

const val OWNER = "rkswlrbduf"

class MainActivity : AppCompatActivity() {

    private var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = recyclerViewAdapter

        val github = GithubClient()
        val disposable = github.getApi().getRepos(intent.extras.get("owner").toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { items -> recyclerViewAdapter.update(items) }

    }
}

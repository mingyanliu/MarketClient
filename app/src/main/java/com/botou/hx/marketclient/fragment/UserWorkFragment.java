package com.botou.hx.marketclient.fragment;


import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.botou.hx.marketclient.R;
import com.botou.hx.marketclient.adapter.UserAdapterAdapter;

public class UserWorkFragment extends BaseFragment {
	private RecyclerView userWorkRV;
	private UserAdapterAdapter adapter;


	@Override
	protected void initData() {

	}

	@Override
	protected void initView(View view) {
		userWorkRV = findView(R.id.userWorkRV, view);
		RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
		userWorkRV.setLayoutManager(manager);
		int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.space);
		userWorkRV.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
		adapter = new UserAdapterAdapter();
		userWorkRV.setAdapter(adapter);
	}

	@Override
	protected int getLayout() {
		return R.layout.fragment_user_work;
	}

	public class SpaceItemDecoration extends RecyclerView.ItemDecoration{

		private int space;

		public SpaceItemDecoration(int space) {
			this.space = space;
		}

		@Override
		public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

			if(parent.getChildPosition(view) != 0)
				outRect.top = space;
		}
	}
}

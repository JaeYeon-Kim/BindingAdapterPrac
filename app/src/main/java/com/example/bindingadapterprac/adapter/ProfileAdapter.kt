package com.example.bindingadapterprac.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bindingadapterprac.databinding.RvItemBinding
import com.example.bindingadapterprac.model.ProfileData

/**
 * 어댑터를 ListAdapter로 선언하고 ProfileData를 아이템으로 가지도록 한다.
 * ListAdapter는 자체적으로 아이템 리스트를 관리하므로 별도의 아이템 리스트를 내부에 생성할 필요 없고,
 * getItem(position)으로 원하는 위치 값을 불러올 수 있다.
 * submitList에 아이템 리스트만 넘겨주면 diffUtil을 통해 바뀐 데이터를 알아서 갱신한다.
 *
 * diffUtil을 보면 1차적으로 areItemsTheSame에서 객체 고유의 값을 비교하도록 하는 것이 좋다.
 * 여기서는 임의로 만든 리스트를 사용하기 때문에 ProfileData의 name을 기준으로 잡는다.
 * ListAdapter에서는 별도로 구현하지 않고도 편리한 메소드 사용이 가능한데 다음과 같다.
 * currentList // 현재 리스트 반환
 * getItem(position) // position 아이템 반환
 * submitList(list) // list 변경
 * 또한 데이터추가, 삭제 시 아이템의 애니메이션도 자동으로 제공한다.
 */
class ProfileAdapter: ListAdapter<ProfileData, ProfileAdapter.MyViewHolder>(diffUtil) {

    inner class MyViewHolder(private val binding: RvItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data : ProfileData) {
            binding.user = data
        }
    }

    // 뷰 홀더 생성 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    // 뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // 리스트 변경
    override fun submitList(list: List<ProfileData>?) {
        super.submitList(list)
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<ProfileData>() {
            // 이름이 같은지 확인 하고 다르면 갱신 해준다.
            override fun areItemsTheSame(oldItem: ProfileData, newItem: ProfileData): Boolean {
                return oldItem.name == newItem.name
            }

            // 모든 속성이 같은지 확인하고 다를 경우 갱신해준다.
            override fun areContentsTheSame(oldItem: ProfileData, newItem: ProfileData): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

        }
    }
}

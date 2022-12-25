package com.example.coordinatorlayout

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.coordinatorlayout.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count: Int = 0
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.root.findViewById<ConstraintLayout>(R.id.constraint1).visibility = View.INVISIBLE
        positionSelection()
    }

    @SuppressLint("ResourceType")
    private fun positionSelection() {
        binding.root.findViewById<ImageButton>(R.id.btn_student).setOnClickListener {
            studentBtnClick()
            binding.root.findViewById<ConstraintLayout>(R.id.constraint2).visibility = View.INVISIBLE
        }
        binding.root.findViewById<ImageButton>(R.id.btn_teacher).setOnClickListener {
            teacherBtnClick()
            binding.root.findViewById<ConstraintLayout>(R.id.constraint2).visibility = View.INVISIBLE
        }
    }

    private fun teacherBtnClick() {
        binding.root.findViewById<ConstraintLayout>(R.id.constraint1).visibility = View.VISIBLE

        binding.text = Text("어떻게 부를까요?","아이디",
            "기억하기 쉬운 아이디로 정해주세요:)","이름","본인의 이름으로 작성해 주세요!",
            "학번","학교 학번 4자리로 입력해 주세요!","계속하기")

        binding.root.findViewById<TextInputLayout>(R.id.edit_third).visibility = View.INVISIBLE
        binding.root.findViewById<TextView>(R.id.tv_third).visibility = View.INVISIBLE


        binding.root.findViewById<Button>(R.id.btn_move).setOnClickListener {
            count+=1
            when (count){
                0->{
                    binding.text = Text("반 입력","학년",
                        "가르치시는 학년을 입력해주세요","반","가르치시는 반을 입력해주세요",
                        "학번","학교 학번 4자리로 입력해 주세요!","회원가입")
                    binding.root.findViewById<TextInputLayout>(R.id.edit_third).visibility = View.INVISIBLE
                    binding.root.findViewById<TextView>(R.id.tv_third).visibility = View.INVISIBLE
                }
                1->{
                    binding.text = Text("비밀번호 입력","비밀번호",
                        "20글자 이상의 비밀번호로 입력해주세요:)","비밀번호 확인","위의 비밀번호와 동일한 비밀번호를 입력해 주세요!",
                        "학번","학교 학번 4자리로 입력해 주세요!","회원가입")
                    binding.root.findViewById<TextInputLayout>(R.id.edit_third).visibility = View.INVISIBLE
                    binding.root.findViewById<TextView>(R.id.tv_third).visibility = View.INVISIBLE
                }
                2->{

                    binding.text = Text("가입코드 입력","가입코드",
                        "지정된 가입코드를 입력해주세요","비밀번호 확인","위의 비밀번호와 동일한 비밀번호를 입력해 주세요!",
                        "학번","학교 학번 4자리로 입력해 주세요!","회원가입")
                    binding.root.findViewById<TextInputLayout>(R.id.edit_third).visibility = View.INVISIBLE
                    binding.root.findViewById<TextView>(R.id.tv_third).visibility = View.INVISIBLE
                    binding.root.findViewById<TextInputLayout>(R.id.edit_second).visibility = View.INVISIBLE
                    binding.root.findViewById<TextView>(R.id.tv_second).visibility = View.INVISIBLE
                }
                else->{
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun studentBtnClick(){
        binding.root.findViewById<ConstraintLayout>(R.id.constraint1).visibility = View.VISIBLE
        binding.text = Text("어떻게 부를까요?","아이디",
            "기억하기 쉬운 아이디로 정해주세요:)","이름","본인의 이름으로 작성해 주세요!",
            "학번","학교 학번 4자리로 입력해 주세요!","계속하기")

        binding.root.findViewById<Button>(R.id.btn_move).setOnClickListener {
            count+=1
            when (count){
                1->{
                    binding.text = Text("비밀번호 입력","비밀번호",
                        "20글자 이상의 비밀번호로 입력해주세요:)","비밀번호 확인","위의 비밀번호와 동일한 비밀번호를 입력해 주세요!",
                        "학번","학교 학번 4자리로 입력해 주세요!","회원가입")
                    binding.root.findViewById<TextInputLayout>(R.id.edit_third).visibility = View.INVISIBLE
                    binding.root.findViewById<TextView>(R.id.tv_third).visibility = View.INVISIBLE
                }
                else->{
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
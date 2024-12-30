package com.example.a7minutesworkout

object Constants {
    fun defaultExerciseList():ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()
        exerciseList.add(ExerciseModel(1, "Jumping Jacks", R.drawable.ic_jumping_jacks, false, false))
        exerciseList.add(ExerciseModel(2, "Wall Sit", R.drawable.ic_wall_sit, false, false))
        exerciseList.add(ExerciseModel(3, "Push Up", R.drawable.ic_push_up, false, false))
        exerciseList.add(ExerciseModel(4, "Abdominal Crunch", R.drawable.ic_abdominal_crunch, false, false))
        exerciseList.add(ExerciseModel(5, "Step Up On Chair", R.drawable.ic_step_up_onto_chair, false, false))
        exerciseList.add(ExerciseModel(6, "Squat", R.drawable.ic_squat, false, false))
        exerciseList.add(ExerciseModel(7, "Tricep Dip On Chair", R.drawable.ic_triceps_dip_on_chair, false, false))
        exerciseList.add(ExerciseModel(8, "Plank", R.drawable.ic_plank, false, false))
        exerciseList.add(ExerciseModel(9, "High Knees Running In Place", R.drawable.ic_high_knees_running_in_place, false, false))
        exerciseList.add(ExerciseModel(10, "Lunge", R.drawable.ic_lunge, false, false))
        exerciseList.add(ExerciseModel(11, "Pushup And Rotation", R.drawable.ic_push_up_and_rotation, false, false))
        exerciseList.add(ExerciseModel(12, "Side Plank", R.drawable.ic_side_plank, false, false))
        return exerciseList
    }
}
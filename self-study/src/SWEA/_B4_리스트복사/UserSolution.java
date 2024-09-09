package SWEA._B4_리스트복사;

import java.util.HashMap;
import java.util.Map;

class UserSolution
{
	
	static Map<String, int[]> listMap;
	static Map<String, Map<Integer, Integer>> updateMap;
	public void init()
	{
		listMap = new HashMap<>();
		updateMap = new HashMap<>();
		
	}

	public void makeList(char mName[], int mLength, int mListValue[])
	{
		System.out.println("makeList 작동");

		String name = getNameFromChar(mName);
		
		int[] arr = new int[mLength];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = mListValue[i];
		}
		
		listMap.put(name, arr);
		System.out.println("makeList 작동 끝");
		
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy)
	{
		String destName = getNameFromChar(mDest);
		String srcName = getNameFromChar(mSrc);

		int[] srcList = listMap.get(srcName);
		int[] arr;
		if (mCopy) {
			arr = new int[srcList.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = srcList[i];
			}
		} else {
			arr = srcList;
		}
		System.out.println("CopyList destName: " + destName);
		listMap.put(destName, arr);
	}

	public void updateElement(char mName[], int mIndex, int mValue)
	{
		String name = getNameFromChar(mName);
		if(updateMap.containsKey(name)) {
			Map map = updateMap.get(name);
			map.put(mIndex, mValue);
		} else {
			Map map = new HashMap<Integer, Integer>();
			map.put(mIndex, mValue);
			updateMap.put(name, map);
		}
	}

	public int element(char mName[], int mIndex)
	{
		String name = getNameFromChar(mName);
		System.out.println(name);
		System.out.println("keyset: " + listMap.keySet());
		
		if (updateMap.containsKey(name) && updateMap.get(name).containsKey(mIndex)) return updateMap.get(name).get(mIndex);
		else return listMap.get(name)[mIndex];
	}
	
	public String getNameFromChar(char mName[]) {
		String name = "";
		for (char n : mName) {
			System.out.print(n + " ");
			name += n;
		}
		System.out.println();
		return name;
	}
}